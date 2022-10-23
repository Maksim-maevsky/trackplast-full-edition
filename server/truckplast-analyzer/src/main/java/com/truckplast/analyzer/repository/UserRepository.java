package com.truckplast.analyzer.repository;

import com.truckplast.analyzer.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = {"roles", "position"})
    List<User> findAll();

    @EntityGraph(attributePaths = {"roles", "position"})
    Optional<User> findById(Long id);
}
