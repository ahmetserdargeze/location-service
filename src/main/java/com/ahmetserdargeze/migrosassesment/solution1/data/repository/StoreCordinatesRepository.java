package com.ahmetserdargeze.migrosassesment.solution1.data.repository;

import com.ahmetserdargeze.migrosassesment.solution1.data.entity.StoresCordinates;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface StoreCordinatesRepository extends CrudRepository<StoresCordinates, UUID> {
    @Query(value = "select * from (SELECT\n" +
            "                   stores_cordinates.store_name,\n" +
            "                   ST_Distance(stores_cordinates.location, st_makepoint( ?1 , ?2  )) as dist\n" +
            "               FROM stores_cordinates ) as distance ORDER BY dist asc \n"
            , nativeQuery = true)
    List<Object[]> getDİstanceFromOurStores(double lng, double lat);

}
