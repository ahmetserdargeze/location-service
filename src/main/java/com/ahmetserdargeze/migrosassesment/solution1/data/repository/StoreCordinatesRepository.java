package com.ahmetserdargeze.migrosassesment.solution1.data.repository;

import com.ahmetserdargeze.migrosassesment.solution1.data.entity.StoresCordinates;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StoreCordinatesRepository extends CrudRepository<StoresCordinates, UUID> {
}
