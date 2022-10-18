package com.truckplast.analyzer.repository;

import com.truckplast.analyzer.entity.part.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
