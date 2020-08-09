package com.ahmetserdargeze.migrosassesment.solution1.model.response;

import org.springframework.http.HttpStatus;

public class CourierLogSaveResponse  extends BaseResponse{
    private long courierId;
    private String nearestMigrosCenter;
    private double distanece;
    public CourierLogSaveResponse(HttpStatus httpStatus, String operationMessage, boolean success, long courierId, String nearestMigrosCenter, double distanece) {
        super(httpStatus, operationMessage, success);
        this.courierId = courierId;
        this.nearestMigrosCenter = nearestMigrosCenter;
        this.distanece = distanece;
    }

    public CourierLogSaveResponse(HttpStatus httpStatus, String operationMessage, boolean success) {
        super(httpStatus, operationMessage, success);
    }

    public long getCourierId() {
        return courierId;
    }

    public void setCourierId(long courierId) {
        this.courierId = courierId;
    }

    public String getNearestMigrosCenter() {
        return nearestMigrosCenter;
    }

    public void setNearestMigrosCenter(String nearestMigrosCenter) {
        this.nearestMigrosCenter = nearestMigrosCenter;
    }

    public double getDistanece() {
        return distanece;
    }

    public void setDistanece(double distanece) {
        this.distanece = distanece;
    }
}
