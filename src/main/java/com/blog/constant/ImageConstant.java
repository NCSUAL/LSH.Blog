package com.blog.constant;

import lombok.Getter;

@Getter
public enum ImageConstant {

    NOT_FOUND_EXCEPTION("해당 이미지를 찾을 수 없습니다.");
    
    private final String message;
    
    ImageConstant(final String message){
        this.message = message;
    }
}
