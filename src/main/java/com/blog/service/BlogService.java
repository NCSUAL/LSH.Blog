package com.blog.service;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import org.springframework.stereotype.Service;

import com.blog.domain.Blog;
import com.blog.exception.blog.NotFoundBlogException;
import com.blog.repository.BlogRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public List<Blog> inquiryAllBlogs(){
        return blogRepository.findAll();
    }

    public Blog inquiryBlog(final Long id){
        return blogRepository.findById(id).orElseThrow(() -> new NotFoundBlogException(BAD_REQUEST, null));
    }

    public Blog amendBlog(){
        
    }

}
