package com.blog.exception.controller;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blog.dto.ApiEntity;
import com.blog.dto.ErrorDto;

@RestControllerAdvice
public class RestControllerExceptionHandler {
 
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException exception){
        return ApiEntity.fail(exception.getBindingResult().getFieldErrors().stream()
        .collect(
            Collectors.toMap(
                arg -> arg.getField(),
                arg -> arg.getDefaultMessage()
        )), ErrorDto.of(HttpStatus.BAD_REQUEST, "필드가 맞지 않습니다.")
        );
    }
}
