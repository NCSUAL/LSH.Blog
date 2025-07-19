package com.blog.common.validator;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.blog.common.annotation.ExpectNull;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ExpectNullValidator implements ConstraintValidator<ExpectNull, Object>{

    private ExpectNull expectNull;

    @Override
    public void initialize(ExpectNull constraintAnnotation) {
        this.expectNull = constraintAnnotation;
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(expectNull.message()).addConstraintViolation();

        return Objects.isNull(value);
    }

}
