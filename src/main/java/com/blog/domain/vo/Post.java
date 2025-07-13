package com.blog.domain.vo;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.Getter;

@Getter
@Embeddable
public class Post {

    private String title;

    @Column(name = "CONTENT", columnDefinition = "TEXT")
    @Lob
    private String content;
    private String author;
}
