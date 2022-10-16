package com.truckplast.analyzer.repository;

import com.truckplast.analyzer.entity.part.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
