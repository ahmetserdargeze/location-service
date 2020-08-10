package com.ahmetserdargeze.migrosassesment.solution1.data.entity;

import com.vividsolutions.jts.geom.Point;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "stores_cordinates")
public class StoresCordinates {

    @Id
    @Column(name = "store_id")
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    private UUID storeId;

    @Column(name = "store_name")
    private String storeName;

    @Column(name = "location")
    private Point location;

    public UUID getStoreId() {
        return storeId;
    }

    public void setStoreId(UUID storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

}
