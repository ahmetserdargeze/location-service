package com.ahmetserdargeze.migrosassesment.solution1.service.impl;

import com.ahmetserdargeze.migrosassesment.solution1.data.entity.CourierLog;
import com.ahmetserdargeze.migrosassesment.solution1.data.entity.CourierNearestStores;
import com.ahmetserdargeze.migrosassesment.solution1.data.repository.CourierLogRepository;
import com.ahmetserdargeze.migrosassesment.solution1.data.repository.CourierRepository;
import com.ahmetserdargeze.migrosassesment.solution1.data.repository.StoreCordinatesRepository;
import com.ahmetserdargeze.migrosassesment.solution1.model.input.CreateCourierLogInput;
import com.ahmetserdargeze.migrosassesment.solution1.model.observer.courier.CourierObservable;
import com.ahmetserdargeze.migrosassesment.solution1.model.observer.courier.CourierObservableData;
import com.ahmetserdargeze.migrosassesment.solution1.model.observer.courier.MobileObserver;
import com.ahmetserdargeze.migrosassesment.solution1.model.response.BaseResponse;
import com.ahmetserdargeze.migrosassesment.solution1.model.response.CourierLogSaveResponse;
import com.ahmetserdargeze.migrosassesment.solution1.model.response.TotalTravelDistanceResponse;
import com.ahmetserdargeze.migrosassesment.solution1.service.contract.CourierService;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CourierServiceImpl extends BaseServiceImpl implements CourierService {
    @Autowired
    CourierRepository courierRepository;
    @Autowired
    CourierLogRepository courierLogRepository;

    @Autowired
    StoreCordinatesRepository storeCordinatesRepository;


    @Override
    @Transactional
    public BaseResponse saveCourierLog(CreateCourierLogInput createCourierLogInput) throws ParseException {
        CourierObservable courierObservable = new CourierObservable();
        MobileObserver courierClient = new MobileObserver();
        courierObservable.addObserver(courierClient);
        CourierLog courierLog = new CourierLog(
                UUID.randomUUID(),
                createCourierLogInput.getCourierId(),
                new Timestamp(createCourierLogInput.getLogTime().getTime()),
                getPointFromLatAndLong(createCourierLogInput.getLat(), createCourierLogInput.getLng()),
                false
        );

        boolean insertResult = insertCourierLog(courierLog);
        if (insertResult) {
            List<CourierNearestStores> courier100MNearestStoresInLast1Minute = getCourier100MNearestStoresInLast1Minute(courierLog.getCourierId(),courierLog.getCourierLogId());
            if (!courier100MNearestStoresInLast1Minute.isEmpty()) {
                var wrapper = new Object() {
                    boolean isNotNotify;
                };
                CourierNearestStores lastLog = courier100MNearestStoresInLast1Minute.stream()
                        .filter(courierNearestStores -> courierLog.getCourierLogId().equals(courierNearestStores.getCourierLogId()))
                        .findAny()
                        .orElse(null);
                courier100MNearestStoresInLast1Minute.forEach(courierNearestStores -> {
                    if (lastLog.getStoreName().equals(courierNearestStores.getStoreName()) && !courierNearestStores.getCourierLogId().equals(courierLog.getCourierLogId()) && courierNearestStores.isNotify()) {
                        wrapper.isNotNotify = true;
                    }
                });
                if (!wrapper.isNotNotify) {
                    courierObservable.setObservableData(new CourierObservableData(courierLog.getCourierId(), lastLog.getStoreName(), lastLog.getDistance()));
                    courierObservable.notifyObserver();
                    courierLog.setNotify(true);
                    insertCourierLog(courierLog);
                }
            }
            return new CourierLogSaveResponse(HttpStatus.OK, "Courier log insert with success", true, courierLog);
        } else {
            return new BaseResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Courier log insert with error", false);
        }

    }

    @Override
    public BaseResponse getTotalTravelDistance(long courierId) {
        try {
            List<Object[]> courierTotalDistance = courierLogRepository.getCourierTotalDistanceWithId(courierId);
            logger.info("Courier total distance get with success");
            if (!courierTotalDistance.isEmpty()) {
                return new TotalTravelDistanceResponse(HttpStatus.OK,
                        "Courier total distance get with success",
                        true,
                        courierId,
                        (Double) courierTotalDistance.get(0)[0]);
            } else {
                return new TotalTravelDistanceResponse(HttpStatus.OK,
                        "Courier total distance get with success but courier not has any travel log",
                        true,
                        courierId,
                        0);
            }
        } catch (Exception e) {
            StringBuilder errorMessage = new StringBuilder();
            errorMessage.append("Total Travel Distance  Get  Error For CourierId:");
            errorMessage.append(courierId);
            errorMessage.append("and Exception Details:");
            errorMessage.append(e.getMessage());
            logger.error(errorMessage.toString());
            return new BaseResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Courier total distance get with error", false);
        }

    }


    private boolean insertCourierLog(CourierLog courierLog) {
        try {
            courierLogRepository.save(courierLog);
            logger.info("CourierLog Insert Success");
            return true;

        } catch (Exception e) {
            logger.error("CourierLog Insert Error", e);
            return false;

        }

    }

    private Point getPointFromLatAndLong(double lat, double lng) throws ParseException {
        StringBuilder builder = new StringBuilder();
        builder.append("POINT(");
        builder.append(lng);
        builder.append(" ");
        builder.append(lat);
        builder.append(")");
        return (Point) new WKTReader().read(builder.toString());


    }

    private List<CourierNearestStores> getCourier100MNearestStoresInLast1Minute(long courierId,UUID courierLogId){
        try {
            return courierLogRepository.findCourier100MNearestStoresInLast1Minute(courierId,courierLogId);
        }catch (Exception e){
            logger.error("User Log Store Distance Join Failed Return Empty List");
            return new ArrayList<>();
        }


    }


}
