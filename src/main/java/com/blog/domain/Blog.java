package com.blog.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.BatchSize;

import com.blog.domain.auditing.BlogAuditing;
import com.blog.domain.vo.Field;
import com.blog.domain.vo.Post;
import com.blog.dto.request.blog.BlogAmendRequest;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * <p>Blog 관련 엔티티</p>
 * @since 2025.07.12
 * @author 이석현
 * @apiNote description
 * <pre>
 *  <p>[pk] BIGINT BLOG_ID | Long id (autoIncrement, notNull) : Blog 엔티티 기본키</p>
 *  <p>[property] Embbedded FIELD | Field field (embbedded,notNull) : 분야 관련</p>
 *  <p>[property] Embbedded Post | Post post (embbedded,notNull) : 글 관련</p>
 * </pre>
 */

@Entity
@Table(name = "BLOG", schema = "blog")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Blog extends BlogAuditing{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "BLOG_ID")
    private Long id;

    @Embedded
    @AttributeOverride(
        name = "fieldName",
        column = @Column(name = "FIELD_NAME", nullable = false)
    )
    private Field field;

    @Embedded
    private Post post;

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @BatchSize(size = 10)
    @Builder.Default
    private List<Image> images = new ArrayList<>();

    public Blog update(BlogAmendRequest blogAmendRequest){
        this.field = blogAmendRequest.field().toEntity();
        this.post = blogAmendRequest.post().toEntity();
        return this;
    }

    public Blog patch(BlogAmendRequest blogAmendRequest){
        if(Objects.nonNull(blogAmendRequest.field())){
            this.field = blogAmendRequest.field().toEntity();
        }
        if(Objects.nonNull(blogAmendRequest.post())){
            this.post = blogAmendRequest.post().toEntity();
        }
        return this;
    }

}
