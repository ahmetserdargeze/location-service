package com.ahmetserdargeze.migrosassesment.solution1.data.repository;

import com.ahmetserdargeze.migrosassesment.solution1.data.entity.CourierLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourierLogRepository extends CrudRepository<CourierLog, Long> {

    @Query(value = "SELECT st_length(ST_MakeLine(ARRAY(SELECT ST_Centroid(geom_location) FROM courier_log WHERE  courier_log.courier_id = ?1 ORDER BY activate_date)), true)", nativeQuery = true)
    List<Object[]> getCourierTotalDistanceWithId(long courierId);

    @Query(value = "select stores_cordinates.store_name,courier_log.courier_log_id,ST_Distance(stores_cordinates.location, courier_log.geom_location) as distance,courier_log.activate_date\n" +
            "from stores_cordinates\n" +
            "inner join  courier_log\n" +
            "on  ST_Distance(stores_cordinates.location, courier_log.geom_location::geometry) <=100 and  courier_log.activate_date >current_timestamp - interval '1 minutes' and courier_id = ?1  order by courier_log.activate_date desc ;\n", nativeQuery = true)
    List<Object[]> getCourierDistanceLower100MetersToStoresLast1Minutes(long courierId);
}



