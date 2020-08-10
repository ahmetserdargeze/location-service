package com.ahmetserdargeze.migrosassesment.solution1.model.observer.courier;

import java.util.List;

public class CourierObservableData {
    private long courierId;
    private String nearestMigrosName;
    private double nearestMigrosDistance;

    public CourierObservableData() {
    }

    public CourierObservableData(long courierId, String nearestMigrosName, double nearestMigrosDistance) {
        this.courierId = courierId;
        this.nearestMigrosName = nearestMigrosName;
        this.nearestMigrosDistance = nearestMigrosDistance;
    }

    public long getCourierId() {
        return courierId;
    }

    public void setCourierId(long courierId) {
        this.courierId = courierId;
    }

    public double getNearestMigrosDistance() {
        return nearestMigrosDistance;
    }

    public void setNearestMigrosDistance(double nearestMigrosDistance) {
        this.nearestMigrosDistance = nearestMigrosDistance;
    }

    public String getNearestMigrosName() {
        return nearestMigrosName;
    }

    public void setNearestMigrosName(String nearestMigrosName) {
        this.nearestMigrosName = nearestMigrosName;
    }
}
