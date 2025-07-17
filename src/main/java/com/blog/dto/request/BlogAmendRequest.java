package com.blog.dto.request;

import com.blog.domain.Blog;
import com.blog.domain.vo.Field;
import com.blog.domain.vo.Post;

public record BlogAmendRequest(
    Long id,
    Field field,
    Post post
) {

    public Blog toEntity(){
        return Blog.builder()
            .field(field)
            .post(post)
            .build();
    }
} 