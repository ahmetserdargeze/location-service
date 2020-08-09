package com.ahmetserdargeze.migrosassesment.solution1.service.impl;

import com.ahmetserdargeze.migrosassesment.solution1.data.repository.CourierLogRepository;
import com.ahmetserdargeze.migrosassesment.solution1.data.repository.CourierRepository;
import com.ahmetserdargeze.migrosassesment.solution1.data.repository.StoreCordinatesRepository;
import com.ahmetserdargeze.migrosassesment.solution1.service.contract.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CourierServiceImpl implements CourierService {
    @Autowired
    CourierRepository courierRepository;
    @Autowired
    CourierLogRepository courierLogRepository;

    @Autowired
    StoreCordinatesRepository storeCordinatesRepository;


    @Override
    public void saveCourierLog(Date logTime, long courierId, double lng, double lat) {


    }
}
