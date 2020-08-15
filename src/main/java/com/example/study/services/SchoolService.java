package com.example.study.services;

import com.example.study.models.School;

import java.util.List;
import java.util.Optional;

/**
 * Service to handle School related operations
 *
 * @author Vinod John
 */
public interface SchoolService {
    /**
     * To create a new school
     *
     * @param school School
     */
    void createSchool(School school);

    /**
     * To get all the schools
     *
     * @return list of schools
     */
    List<School> getAllSchools();

    /**
     * To find school by school name
     *
     * @param name School name
     * @return optional of school
     */
    Optional<School> findSchoolByName(String name);
}
