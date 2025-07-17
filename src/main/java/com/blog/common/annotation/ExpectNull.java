package com.blog.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.RECORD_COMPONENT,ElementType.PARAMETER})
public @interface ExpectNull {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
