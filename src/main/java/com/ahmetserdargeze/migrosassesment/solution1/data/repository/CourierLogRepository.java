package com.ahmetserdargeze.migrosassesment.solution1.data.repository;

import com.ahmetserdargeze.migrosassesment.solution1.data.entity.CourierLog;
import com.ahmetserdargeze.migrosassesment.solution1.data.entity.CourierNearestStores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CourierLogRepository extends JpaRepository<CourierLog, Long> {

    @Query(value = "SELECT st_length(ST_MakeLine(ARRAY(SELECT ST_Centroid(geom_location) FROM courier_log WHERE  courier_log.courier_id = ?1 ORDER BY activate_date)), true)", nativeQuery = true)
    List<Object[]> getCourierTotalDistanceWithId(long courierId);

    @Query(nativeQuery = true)
    List<CourierNearestStores> findCourier100MNearestStoresInLast1Minute(@Param("courierId") long courierId);
}



