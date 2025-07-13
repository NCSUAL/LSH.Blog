package com.blog.domain;

import com.blog.domain.auditing.BlogAuditing;
import com.blog.domain.vo.Field;
import com.blog.domain.vo.Post;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
 *  <p>[pk] BIGINT BLOG_ID | Long id (sequence, notNull) : Blog 엔티티 기본키</p>
 *  <p>[property] Embbedded FIELD | Field field (embbedded,notNull) : 분야 관련</p>
 *  <p>[property] Embbedded Post | Post post (embbedded,notNull) : 글 관련</p>
 * </pre>
 */

@Entity
@Table(name = "BLOG", schema = "blog")
@SequenceGenerator(
    name = "BLOG_SEQUENCE_GENERATOR", sequenceName = "BLOG_SEQUENCE",
    initialValue = 5, allocationSize = 100
)
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Blog extends BlogAuditing{
    
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "BLOG_SEQUENCE_GENERATOR")
    @Column(nullable = false, name = "BLOG_ID")
    private Long id;

    @Column(nullable = false, name = "FIELD")
    @Embedded
    private Field field;

    @Column(nullable = false, name = "POST")
    @Embedded
    private Post post;


}
