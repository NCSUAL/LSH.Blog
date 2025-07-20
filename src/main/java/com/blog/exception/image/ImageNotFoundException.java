package com.blog.exception.image;

import org.springframework.http.HttpStatus;

import com.blog.exception.BasicException;

import lombok.Builder;
import lombok.Getter;

@Getter
public final class ImageNotFoundException extends BasicException{
    private final HttpStatus httpStatus;
    private final String message;

    @Builder
    public ImageNotFoundException(final HttpStatus httpStatus, final String message){
        super(httpStatus, message);
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
