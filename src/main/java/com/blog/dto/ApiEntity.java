package com.blog.dto;

import java.util.Optional;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record ApiEntity <T>(
    @JsonIgnore
    HttpStatus httpStatus,

    Optional<T> data,

    boolean success,
    
    Optional<ErrorDto> errorDto
) {

    public static <T> ApiEntity<T> ok(T data){
        return new ApiEntity<>(HttpStatus.OK, Optional.of(data), true, Optional.empty());
    }

    public static <T> ApiEntity<T> fail(T data, ErrorDto errorDto){
        return new ApiEntity<>(HttpStatus.BAD_REQUEST, Optional.of(data), false, Optional.of(errorDto));
    }

    public static ApiEntity<?> fail(ErrorDto errorDto){
        return new ApiEntity<>(HttpStatus.BAD_REQUEST, Optional.empty(), false, Optional.of(errorDto));
    }

}
