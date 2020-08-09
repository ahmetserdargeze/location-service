package com.ahmetserdargeze.migrosassesment.solution1.data.entity;



import com.vividsolutions.jts.geom.Point;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "courier_log")
public class CourierLog {

    @Id
    @Column(name = "courier_log_id")
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    private UUID courierLogId;

    @Column(name = "courier_id")
    private long courierId;

    @Column(name = "activate_date")
    private Timestamp activateDate;

    @Column(name = "geom_location")
    @Type(type = "jts_geometry")
    private Point geomLocation;

    public CourierLog() {
    }

    public CourierLog(UUID courierLogId, long courierId, Timestamp activateDate, Point geomLocation) {
        this.courierLogId = courierLogId;
        this.courierId = courierId;
        this.activateDate = activateDate;
        this.geomLocation = geomLocation;
    }

    public void setCourierLogId(UUID courierLogId) {
        this.courierLogId = courierLogId;
    }

    public void setCourierId(long courierId) {
        this.courierId = courierId;
    }

    public UUID getCourierLogId() {
        return courierLogId;
    }

    public long getCourierId() {
        return courierId;
    }

    public Timestamp getActivateDate() {
        return activateDate;
    }

    public void setActivateDate(Timestamp activateDate) {
        this.activateDate = activateDate;
    }

    public Point getGeomLocation() {
        return geomLocation;
    }

    public void setGeomLocation(Point geomLocation) {
        this.geomLocation = geomLocation;
    }
}
