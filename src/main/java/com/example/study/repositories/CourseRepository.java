package com.example.study.repositories;

import com.example.study.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to handle course related queries
 *
 * @author Vinod John
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
