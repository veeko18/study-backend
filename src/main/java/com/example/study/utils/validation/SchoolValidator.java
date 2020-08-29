package com.example.study.utils.validation;

import com.example.study.models.School;
import com.example.study.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Constraint validator to check school is valid
 *
 * @author Vinod John
 */
@Component
public class SchoolValidator implements ConstraintValidator<ValidSchool, School> {
    @Autowired
    private SchoolService schoolService;

    @Override
    public void initialize(ValidSchool constraintAnnotation) {

    }

    @Override
    public boolean isValid(School school, ConstraintValidatorContext constraintValidatorContext) {
        return schoolService.findSchoolByName(school.getName()).isEmpty();
    }
}
