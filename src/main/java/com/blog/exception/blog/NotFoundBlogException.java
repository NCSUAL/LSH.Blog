package com.blog.exception.blog;

import org.springframework.http.HttpStatus;

import com.blog.exception.BasicException;

public class NotFoundBlogException extends BasicException{
    public NotFoundBlogException(final HttpStatus httpStatus, final String message){
        super(httpStatus, message);
    }
}
