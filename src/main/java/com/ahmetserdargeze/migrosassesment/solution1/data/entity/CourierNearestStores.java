package com.ahmetserdargeze.migrosassesment.solution1.data.entity;

import javax.persistence.Column;
import java.util.Date;
import java.util.UUID;

public class CourierNearestStores {
    @Column(name = "store_name")
    private String storeName;

    @Column(name = "courier_log_id")
    private UUID courierLogId;

    @Column(name = "distance")
    private Double distance;

    @Column(name = "activate_date")
    private Date activateDate;

    @Column(name = "is_notify")
    private boolean isNotify;

    public CourierNearestStores(String storeName, UUID courierLogId, Double distance, Date activateDate, boolean isNotify) {
        this.storeName = storeName;
        this.courierLogId = courierLogId;
        this.distance = distance;
        this.activateDate = activateDate;
        this.isNotify = isNotify;
    }

    public CourierNearestStores() {
    }

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

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Date getActivateDate() {
        return activateDate;
    }

    public void setActivateDate(Date activateDate) {
        this.activateDate = activateDate;
    }

    public boolean isNotify() {
        return isNotify;
    }

    public void setNotify(boolean notify) {
        isNotify = notify;
    }
}
