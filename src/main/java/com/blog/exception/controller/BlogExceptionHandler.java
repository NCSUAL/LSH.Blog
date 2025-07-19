package com.blog.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blog.dto.ApiEntity;
import com.blog.dto.ErrorDto;
import com.blog.exception.blog.NotFoundBlogException;
import com.blog.exception.blog.NotFoundFieldException;

@RestControllerAdvice
public class BlogExceptionHandler {

    @ExceptionHandler({NotFoundBlogException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiEntity<?> notFoundBlogException(NotFoundBlogException notFoundBlogException){
        return ApiEntity.fail(ErrorDto.of(notFoundBlogException));
    }

    @ExceptionHandler({NotFoundFieldException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiEntity<?> notFoundFieldException(NotFoundFieldException exception){
        return ApiEntity.fail(ErrorDto.of(exception));
    }
    
}
