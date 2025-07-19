package com.blog.constant;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.blog.exception.blog.NotFoundFieldException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public enum FieldName {

    SPRING("spring", "스프링");

    private final String skill;
    private final String description;
    
    FieldName(final String skill, final String description){
        this.description = description;
        this.skill = skill;
    }

    @JsonCreator
    public static FieldName of(@JsonProperty("field") final String field){
        return Arrays.stream(FieldName.values())
        .filter(fieldName -> fieldName.getSkill().equalsIgnoreCase(field))
        .findAny()
        .orElseThrow(() -> new NotFoundFieldException(HttpStatus.BAD_REQUEST, "해당 분야는 존재하지 않습니다."));
    }

}
