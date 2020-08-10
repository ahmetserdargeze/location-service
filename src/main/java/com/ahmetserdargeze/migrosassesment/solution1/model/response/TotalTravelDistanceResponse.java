package com.ahmetserdargeze.migrosassesment.solution1.model.response;

import org.springframework.http.HttpStatus;

public class TotalTravelDistanceResponse extends BaseResponse {
    private long courierId;
    private double totalDistance;

    public TotalTravelDistanceResponse(HttpStatus httpStatus, String operationMessage, boolean success) {
        super(httpStatus, operationMessage, success);
    }

    public TotalTravelDistanceResponse(HttpStatus httpStatus, String operationMessage, boolean success, long courierId, double totalDistance) {
        super(httpStatus, operationMessage, success);
        this.courierId = courierId;
        this.totalDistance = totalDistance;
    }

    public long getCourierId() {
        return courierId;
    }

    public void setCourierId(long courierId) {
        this.courierId = courierId;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }
}
