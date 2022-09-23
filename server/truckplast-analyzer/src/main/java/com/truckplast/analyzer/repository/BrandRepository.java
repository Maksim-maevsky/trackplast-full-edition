package com.truckplast.analyzer.repository;


import com.truckplast.analyzer.entity.part.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    Optional<Brand> findByName(String name);

}
