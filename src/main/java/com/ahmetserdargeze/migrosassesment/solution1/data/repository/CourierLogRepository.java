package com.ahmetserdargeze.migrosassesment.solution1.data.repository;

import com.ahmetserdargeze.migrosassesment.solution1.data.entity.CourierLog;
import com.ahmetserdargeze.migrosassesment.solution1.data.entity.CourierNearestStores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


public interface CourierLogRepository extends JpaRepository<CourierLog, Long> {

    @Query(value = "SELECT st_length(ST_MakeLine(ARRAY(SELECT ST_Centroid(geom_location) FROM courier_log WHERE  courier_log.courier_id = ?1 ORDER BY activate_date)), true)", nativeQuery = true)
    List<Object[]> getCourierTotalDistanceWithId(long courierId);

    //    @Query(value = "select new CourierNearestStores(stores_cordinates.store_name,courier_log.courier_log_id,ST_Distance(stores_cordinates.location, courier_log.geom_location) as distance,courier_log.activate_date)\n" +
//            "from stores_cordinates\n" +
//            "inner join  courier_log\n" +
//            "on  ST_Distance(stores_cordinates.location, courier_log.geom_location::geometry) <=100 and  courier_log.activate_date >current_timestamp - interval '100000 minutes' and courier_id = ?1  order by courier_log.activate_date desc ;\n", nativeQuery = true)
    @Query(nativeQuery = true)
    List<CourierNearestStores> test();
}



