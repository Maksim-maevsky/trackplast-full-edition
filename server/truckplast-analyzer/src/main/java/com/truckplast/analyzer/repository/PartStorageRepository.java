package com.truckplast.analyzer.repository;

import com.truckplast.analyzer.entity.part.PartWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartStorageRepository extends JpaRepository<PartWarehouse, Short> {

}
