package com.ahmetserdargeze.migrosassesment.solution1.service.impl;

import com.ahmetserdargeze.migrosassesment.solution1.data.entity.CourierLog;
import com.ahmetserdargeze.migrosassesment.solution1.data.entity.CourierNearestStores;
import com.ahmetserdargeze.migrosassesment.solution1.data.repository.CourierLogRepository;
import com.ahmetserdargeze.migrosassesment.solution1.data.repository.CourierRepository;
import com.ahmetserdargeze.migrosassesment.solution1.data.repository.StoreCordinatesRepository;

import com.ahmetserdargeze.migrosassesment.solution1.model.response.BaseResponse;
import com.ahmetserdargeze.migrosassesment.solution1.model.response.CourierLogSaveResponse;
import com.ahmetserdargeze.migrosassesment.solution1.model.response.TotalTravelDistanceResponse;
import com.ahmetserdargeze.migrosassesment.solution1.service.contract.CourierService;
import com.ahmetserdargeze.migrosassesment.solution1.model.observer.courier.CourierObservable;
import com.ahmetserdargeze.migrosassesment.solution1.model.observer.courier.MobileObserver;
import com.ahmetserdargeze.migrosassesment.solution1.model.observer.courier.CourierObservableData;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
    public BaseResponse saveCourierLog(Date logTime, long courierId, double lng, double lat) {
        CourierObservable courierObservable = new CourierObservable();
        MobileObserver courierClient = new MobileObserver();
        courierObservable.addObserver(courierClient);
        GeometryFactory factory = new GeometryFactory();
        try {
            CourierLog courierLog = new CourierLog(
                    UUID.randomUUID(),
                    courierId,
                    new Timestamp(new Date().getTime()),
                    factory.createPoint(new Coordinate(lng, lat))
            );
            courierLogRepository.save(courierLog);
            logger.info("CourierLog Insert Success");
//            List<Object[]> storeDistances = storeCordinatesRepository.getDİstanceFromOurStores(lng,lat);
            List<CourierNearestStores> courier100MNearestStoresInLast1Minute = courierLogRepository.test();
//            courierObservable.setObservableData(new CourierObservableData(courierId,storeDistances));
//            courierObservable.notifyObserver();

            return new CourierLogSaveResponse(HttpStatus.OK, "Courier log insert with success", true, courierId, "TEST", 0D);

        } catch (Exception e) {
            StringBuilder errorMessage = new StringBuilder();
            errorMessage.append("CourierLog Insert Error:");
            errorMessage.append(e.getMessage());
                logger.error(errorMessage.toString());
            logger.error("sad",e);
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

}
