package com.blog.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.blog.common.validator.ExpectNullValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.RECORD_COMPONENT,ElementType.PARAMETER})
@Constraint(validatedBy = ExpectNullValidator.class)
public @interface ExpectNull {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
