package com.blog.exception.blog;

import org.springframework.http.HttpStatus;

import com.blog.exception.BasicException;

public class NotFoundFieldException extends BasicException{

    public NotFoundFieldException(final HttpStatus httpStatus, final String message){
        super(httpStatus,message);
    }
}
