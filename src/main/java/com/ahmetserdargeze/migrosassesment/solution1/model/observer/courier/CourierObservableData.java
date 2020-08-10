package com.ahmetserdargeze.migrosassesment.solution1.model.observer.courier;

import java.util.List;

public class CourierObservableData {
    private long courierId;
    private double nearestMigrosDistance;
    private String nearestMigrosName;

    public CourierObservableData() {
    }

    public CourierObservableData(long courierId, List<Object[]> storeDistances) {
        this.courierId = courierId;
        if (storeDistances != null && !storeDistances.isEmpty()) {
            this.nearestMigrosName = (String) storeDistances.get(0)[0];
            this.nearestMigrosDistance = (Double) storeDistances.get(0)[1];
        }
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
