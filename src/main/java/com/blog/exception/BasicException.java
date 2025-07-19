package com.blog.exception;

import org.springframework.http.HttpStatus;

public class BasicException extends RuntimeException{

    private final HttpStatus httpStatus;

    public BasicException(final HttpStatus httpStatus,final String message){
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus(){
        return httpStatus;
    }
}
