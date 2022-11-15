package com.truckplast.analyzer.repository;


import com.truckplast.analyzer.entity.part.PartInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface PartInfoRepository extends JpaRepository<PartInfo, UUID> {

    @Query("SELECT distinct pi FROM PartInfo pi WHERE pi.partWarehouse.name IN :partWarehouseNameSet")
    List<PartInfo> findAllByPartWarehouseName(Set<String> partWarehouseNameSet);

    @Transactional
    void deleteByPartWarehouseId(short id);

    int countAllByPartWarehouseId(short id);

    @Query("SELECT SUM(pi.price * pi.count) FROM PartInfo pi WHERE pi.partWarehouse.id = :id")
    Optional<Double> countAllPriceByPartWarehouseId(Short id);

}
