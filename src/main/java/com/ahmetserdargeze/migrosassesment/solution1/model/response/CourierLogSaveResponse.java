package com.ahmetserdargeze.migrosassesment.solution1.model.response;

import com.ahmetserdargeze.migrosassesment.solution1.data.entity.CourierLog;
import org.springframework.http.HttpStatus;

public class CourierLogSaveResponse  extends BaseResponse{
    private CourierLog insertedLog;

    public CourierLogSaveResponse(HttpStatus httpStatus, String operationMessage, boolean success, CourierLog courierLog) {
        super(httpStatus, operationMessage, success);
        this.insertedLog = courierLog;
    }

    public CourierLog getInsertedLog() {
        return insertedLog;
    }

    public void setInsertedLog(CourierLog insertedLog) {
        this.insertedLog = insertedLog;
    }
}
