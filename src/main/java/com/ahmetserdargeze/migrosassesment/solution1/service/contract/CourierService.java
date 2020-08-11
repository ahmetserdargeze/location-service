package com.ahmetserdargeze.migrosassesment.solution1.service.contract;

import com.ahmetserdargeze.migrosassesment.solution1.model.input.CreateCourierLogInput;
import com.ahmetserdargeze.migrosassesment.solution1.model.response.BaseResponse;
import org.locationtech.jts.io.ParseException;

public interface CourierService {
    BaseResponse saveCourierLog(CreateCourierLogInput createCourierLogInput) throws ParseException;
    BaseResponse getTotalTravelDistance(long courierId);


}
