package com.blog.common.converter;


import java.util.Arrays;
import org.springframework.http.HttpStatus;

import com.blog.constant.FieldName;
import com.blog.exception.blog.NotFoundFieldException;

import jakarta.persistence.AttributeConverter;

public class FieldNameConverter implements AttributeConverter<FieldName, String>{

    @Override
    public String convertToDatabaseColumn(FieldName attribute) {
        return attribute.getSkill();
    }

    @Override
    public FieldName convertToEntityAttribute(String dbData) {
        return Arrays.stream(FieldName.values())
        .filter(fieldName -> fieldName.getSkill().equals(dbData))
        .findAny()
        .orElseThrow(() -> new NotFoundFieldException(HttpStatus.INTERNAL_SERVER_ERROR, "예기치 않은 오류가 발생했습니다."));
    }

}
