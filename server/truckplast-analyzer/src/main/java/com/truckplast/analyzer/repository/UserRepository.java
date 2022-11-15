package com.truckplast.analyzer.repository;

import com.truckplast.analyzer.entity.user.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = {"roles", "position", "company"})
    List<User> findAll();

    @EntityGraph(attributePaths = {"roles", "position", "company"})
    Optional<User> findById(Long id);
}
