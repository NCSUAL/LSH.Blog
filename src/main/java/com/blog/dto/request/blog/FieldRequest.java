package com.blog.dto.request.blog;

import com.blog.common.CRUD.Create;
import com.blog.common.CRUD.Patch;
import com.blog.common.CRUD.Update;
import com.blog.constant.FieldName;
import com.blog.domain.vo.Field;
import com.fasterxml.jackson.annotation.JsonView;

public record FieldRequest(
    @JsonView({Create.class,Update.class, Patch.class})
    FieldName fieldName
) {
    public Field toEntity(){
        return Field.builder()
            .fieldName(fieldName)
            .build();
    }
} 
