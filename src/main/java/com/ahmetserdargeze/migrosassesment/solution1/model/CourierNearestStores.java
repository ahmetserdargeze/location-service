package com.ahmetserdargeze.migrosassesment.solution1.model;

import java.sql.Timestamp;
import java.util.UUID;

public class CourierNearestStores {
    private String storeName;
    private UUID courierLogId;
    private double distance;
    private Timestamp activateDate;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public UUID getCourierLogId() {
        return courierLogId;
    }

    public void setCourierLogId(UUID courierLogId) {
        this.courierLogId = courierLogId;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Timestamp getActivateDate() {
        return activateDate;
    }

    public void setActivateDate(Timestamp activateDate) {
        this.activateDate = activateDate;
    }
}
