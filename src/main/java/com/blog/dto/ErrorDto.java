package com.blog.dto;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorDto {
    private final int errorCode;
    private final String errorMessage;

    public static ErrorDto of(final HttpStatus httpStatus, final String message){
        return new ErrorDto(httpStatus.value(), message);
    }
}
