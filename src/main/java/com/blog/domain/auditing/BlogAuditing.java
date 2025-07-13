package com.blog.domain.auditing;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
@EntityListeners(EntityListeners.class)
public class BlogAuditing {

    @Column(name = "created_at",nullable = false, insertable = true, updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "last_modified_at",nullable = false, insertable = true, updatable = true)
    @LastModifiedDate
    private LocalDateTime lastModifiedAt;
}
