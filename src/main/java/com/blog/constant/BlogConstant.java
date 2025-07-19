package com.blog.constant;

import lombok.Getter;

@Getter
public enum BlogConstant {

    NOT_FOUND_EXCEPTION("해당 Blog 엔티티를 찾을 수 없습니다."),
    SUCCESS_DELETE("해당 엔티티를 삭제했습니다.");
    private final String mesage;

    BlogConstant(final String message){
        this.mesage = message;
    }
}
