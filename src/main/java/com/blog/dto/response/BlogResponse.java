package com.blog.dto.response;

import com.blog.domain.Blog;
import com.blog.domain.vo.Field;
import com.blog.domain.vo.Post;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class BlogResponse {
    private final Long id;
    private final Field field;
    private final Post post;

    public static BlogResponse of(final Blog blog){
        return BlogResponse.builder()
            .id(blog.getId())
            .field(blog.getField())
            .post(blog.getPost())
            .build();
    }
}
