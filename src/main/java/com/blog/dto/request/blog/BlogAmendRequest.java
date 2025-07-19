package com.blog.dto.request.blog;


import com.blog.common.CRUD.Create;
import com.blog.common.CRUD.Delete;
import com.blog.common.CRUD.Patch;
import com.blog.common.CRUD.Read;
import com.blog.common.CRUD.Update;
import com.blog.common.annotation.ExpectNull;
import com.blog.constant.ValidatorConstant;
import com.blog.domain.Blog;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.constraints.*;

/**
 * Blog API 관련 JSON(Body)를 받는 dto
 * 
 * @since 2025.07.19
 * @author LSH
 */
public record BlogAmendRequest(
    /**
     * 수정(Update) 시 필수, 나머지(Read/Create/Patch/Delete)에서는 null이어야 함
     */
    @JsonView({Update.class})
    @NotNull(
        groups = {Update.class},
        message = ValidatorConstant.NOTNULL
    )
    @ExpectNull(
        groups = {Read.class, Create.class, Patch.class, Delete.class},
        message =  ValidatorConstant.EXPECTNULL
    )
    Long id,

    /**
     * 수정(Update) 시 필수, 나머지 일부(Read/Delete)에서는 null이어야 함
     */
    @JsonView({Create.class,Update.class, Patch.class})
    @NotNull(
        groups = {Create.class,Update.class},
        message = ValidatorConstant.NOTNULL
    )
    @ExpectNull(
        groups = {Read.class, Delete.class},
        message =  ValidatorConstant.EXPECTNULL
    )
    FieldRequest field,

    /**
     * 수정(Update) 시 필수, 나머지 일부(Read/Delete)에서는 null이어야 함
     */
    @JsonView({Create.class,Update.class, Patch.class})
    @NotNull(
        groups = {Create.class,Update.class},
        message = ValidatorConstant.NOTNULL
    )
    @ExpectNull(
        groups = {Read.class, Delete.class},
        message =  ValidatorConstant.EXPECTNULL
    )
    PostRequest post
) {

    public Blog toEntity(){
        return Blog.builder()
            .field(field.toEntity())
            .post(post.toEntity())
            .build();
    }
} 