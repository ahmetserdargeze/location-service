package com.ahmetserdargeze.migrosassesment.solution1.model.data.repository;

import com.ahmetserdargeze.migrosassesment.solution1.model.data.entity.CourierLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourierLogRepository extends CrudRepository<CourierLog, Long> {

    @Query(value = "SELECT st_length(ST_MakeLine(ARRAY(SELECT ST_Centroid(geom_location) FROM courier_log WHERE  courier_log.courier_id = ?1 ORDER BY activate_date)), true)", nativeQuery = true)
    List<Object[]> getCourierTotalDistanceWithId(long courierId);
}



