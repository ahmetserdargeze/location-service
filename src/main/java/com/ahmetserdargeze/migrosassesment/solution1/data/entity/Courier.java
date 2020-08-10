package com.ahmetserdargeze.migrosassesment.solution1.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courier")
public class Courier {
    @Column(name = "courier_id")
    @Id
    private long courierId;

    @Column(name = "courier_name")
    private String courierName;


    public long getCourierId() {
        return courierId;
    }

    public void setCourierId(long courierId) {
        this.courierId = courierId;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }
}
