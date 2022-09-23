package com.truckplast.analyzer.repository;


import com.truckplast.analyzer.entity.part.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface PartRepository extends JpaRepository<Part, UUID> {


    @Query("select p.id from Part p where p.code = :code and p.brand.name = :brand")
    Optional<UUID> findIdByCodeAndBrandName(String code, String brand);

    Optional<Part> findByCodeAndAndBrandName(String code, String brand);

}
