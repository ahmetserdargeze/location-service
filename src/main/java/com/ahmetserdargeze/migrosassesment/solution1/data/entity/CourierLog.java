package com.ahmetserdargeze.migrosassesment.solution1.data.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Entity(name = "CourierLog")
@SqlResultSetMapping(
        name = "CourierLogNearestStoresMapping",
        classes = @ConstructorResult(
                targetClass = CourierNearestStores.class,
                columns = {@ColumnResult(name = "store_name"),
                        @ColumnResult(name = "courier_log_id", type = UUID.class),
                        @ColumnResult(name = "distance", type = Double.class),
                        @ColumnResult(name = "activate_date", type = Date.class),
                        @ColumnResult(name = "is_notify", type = boolean.class)
                }))
@NamedNativeQuery(
        name = "CourierLog.findCourier100MNearestStoresInLast1Minute",
        query = "select stores_cordinates.store_name,courier_log.courier_log_id,ST_Distance(stores_cordinates.location, courier_log.geom_location) as distance,courier_log.activate_date , courier_log.is_notify\n" +
                "from stores_cordinates\n" +
                "inner join  courier_log\n" +
                "on  ST_Distance(stores_cordinates.location, courier_log.geom_location) <=100 and courier_log.courier_id =:courierId and  courier_log.activate_date >current_timestamp - interval '1 minutes'   order by courier_log.activate_date desc ;\n",
        resultSetMapping = "CourierLogNearestStoresMapping")

@Table(name = "courier_log")
@JsonIgnoreProperties(value = "geomLocation")
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
//    @Type(type = "jts_geometry")
    private org.locationtech.jts.geom.Point geomLocation;


    @Column(name = "isNotify")
    private boolean isNotify;

    public CourierLog() {
    }

    public CourierLog(UUID courierLogId, long courierId, Timestamp activateDate, org.locationtech.jts.geom.Point geomLocation, boolean isNotify) {
        this.courierLogId = courierLogId;
        this.courierId = courierId;
        this.activateDate = activateDate;
        this.geomLocation = geomLocation;
        this.isNotify = isNotify;
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

    public boolean isNotify() {
        return isNotify;
    }

    public void setNotify(boolean notify) {
        isNotify = notify;
    }
}
