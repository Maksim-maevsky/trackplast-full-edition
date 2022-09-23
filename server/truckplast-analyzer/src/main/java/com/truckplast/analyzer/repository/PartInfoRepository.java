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

    @Query("SELECT distinct pi FROM PartInfo pi WHERE pi.partStorage.name IN :partStorageNameSet")
    List<PartInfo> findAllByPartStorageName(Set<String> partStorageNameSet);

    @Transactional
    void deleteByPartStorageId(short id);

    int countAllByPartStorageId(short id);

    @Query("SELECT SUM(pi.price * pi.count) FROM PartInfo pi WHERE pi.partStorage.id = :id")
    Optional<Double> countAllPriceByPartStorageId(Short id);

}
