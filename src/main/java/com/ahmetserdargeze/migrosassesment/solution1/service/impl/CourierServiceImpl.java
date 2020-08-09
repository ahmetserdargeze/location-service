package com.ahmetserdargeze.migrosassesment.solution1.service.impl;

import com.ahmetserdargeze.migrosassesment.solution1.model.data.entity.CourierLog;
import com.ahmetserdargeze.migrosassesment.solution1.model.data.repository.CourierLogRepository;
import com.ahmetserdargeze.migrosassesment.solution1.model.data.repository.CourierRepository;
import com.ahmetserdargeze.migrosassesment.solution1.model.data.repository.StoreCordinatesRepository;
import com.ahmetserdargeze.migrosassesment.solution1.model.response.BaseResponse;
import com.ahmetserdargeze.migrosassesment.solution1.model.response.CourierLogSaveResponse;
import com.ahmetserdargeze.migrosassesment.solution1.service.contract.CourierService;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
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
            return new CourierLogSaveResponse(HttpStatus.OK, "Courier log insert with success", true, courierId, "TEST", 0D);

        } catch (Exception e) {
            StringBuilder errorMessage = new StringBuilder();
            errorMessage.append("CourierLog Insert Error:");
            errorMessage.append(e.getMessage());
            logger.error(errorMessage.toString());
            return new BaseResponse(HttpStatus.OK, "Courier log insert with error", false);

        }
    }
}
