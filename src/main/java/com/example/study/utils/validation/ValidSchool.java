package com.example.study.utils.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Constraint annotation for School validation
 *
 * @author Vinod John
 */
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Constraint(validatedBy = {SchoolValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSchool {
    String message() default "{messages.constraints.invalid-school}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
