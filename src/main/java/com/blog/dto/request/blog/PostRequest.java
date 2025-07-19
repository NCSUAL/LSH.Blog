package com.blog.dto.request.blog;

import com.blog.common.CRUD.Create;
import com.blog.common.CRUD.Patch;
import com.blog.common.CRUD.Update;
import com.blog.domain.vo.Post;
import com.fasterxml.jackson.annotation.JsonView;

public record PostRequest(
    @JsonView({Create.class,Update.class, Patch.class})
    String title,

    @JsonView({Create.class,Update.class, Patch.class})
    String content,

    @JsonView({Create.class,Update.class, Patch.class})
    String author
) {

    public Post toEntity(){
        return Post.builder()
            .author(author)
            .content(content)
            .title(title)
            .build();
    }
}
