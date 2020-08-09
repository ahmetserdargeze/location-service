package com.ahmetserdargeze.migrosassesment.solution1.service.contract;

import com.ahmetserdargeze.migrosassesment.solution1.model.response.BaseResponse;

import java.util.Date;

public interface CourierService {
    BaseResponse saveCourierLog(Date logTime, long courierId, double lng, double lat);


}
