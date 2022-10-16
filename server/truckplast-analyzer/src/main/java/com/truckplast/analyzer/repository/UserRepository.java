package com.truckplast.analyzer.repository;

import com.truckplast.analyzer.entity.part.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
