package com.truckplast.analyzer.repository;

import com.truckplast.analyzer.entity.part.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
