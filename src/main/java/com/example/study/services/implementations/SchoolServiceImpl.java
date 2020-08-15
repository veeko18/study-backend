package com.example.study.services.implementations;

import com.example.study.models.School;
import com.example.study.repositories.SchoolRepository;
import com.example.study.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of school service
 *
 * @author Vinod John
 */
@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public void createSchool(School school) {
        school.setActive(true);
        schoolRepository.save(school);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public Optional<School> findSchoolByName(String name) {
        return schoolRepository.findByName(name);
    }

    @Override
    public Optional<School> findSchoolById(Long id) {
        return schoolRepository.findById(id);
    }

    @Override
    public void updateSchool(School school) {
        schoolRepository.saveAndFlush(school);
    }

    @Override
    public void deleteSchoolById(Long id) {
        findSchoolById(id).ifPresent(school -> {
            school.setActive(false);
            updateSchool(school);
        });
    }

    @Override
    public void fullDeleteSchoolById(Long id) {
        findSchoolById(id).ifPresent(school -> {
            schoolRepository.delete(school);
        });
    }

    @Override
    public void restoreSchoolById(Long id) {
        findSchoolById(id).ifPresent(school -> {
            school.setActive(true);
            updateSchool(school);
        });
    }
}
