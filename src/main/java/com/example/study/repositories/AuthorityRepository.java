package com.example.study.repositories;

import com.example.study.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository to handle authority related queries
 *
 * @author Vinod John
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Optional<Authority> findByName(String name);
}
