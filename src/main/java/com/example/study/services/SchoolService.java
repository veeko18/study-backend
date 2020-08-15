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
     * To get list of active schools
     *
     * @return list of schools
     */
    List<School> getActiveSchools();

    /**
     * To find school by name
     *
     * @param name School name
     * @return optional of school
     */
    Optional<School> findSchoolByName(String name);

    /**
     * To find school by id
     *
     * @param id School id
     * @return optional of school
     */
    Optional<School> findSchoolById(Long id);

    /**
     * To update an existing school
     *
     * @param school School
     */
    void updateSchool(School school);

    /**
     * To delete school by id
     *
     * @param id School id
     */
    void deleteSchoolById(Long id);

    /**
     * To delete school from database completely by id
     *
     * @param id School id
     */
    void fullDeleteSchoolById(Long id);

    /**
     * To restore school by id
     *
     * @param id School id
     */
    void restoreSchoolById(Long id);
}
