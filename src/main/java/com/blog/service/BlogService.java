package com.blog.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.blog.constant.BlogConstant;
import com.blog.domain.Blog;
import com.blog.dto.request.blog.BlogAmendRequest;
import com.blog.exception.blog.NotFoundBlogException;
import com.blog.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import static org.springframework.http.HttpStatus.*;


@RequiredArgsConstructor
@Transactional
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public List<Blog> inquiryAllBlogs(){
        return blogRepository.findAll();
    }

    public Blog createBlog(final BlogAmendRequest blogAmendRequest){
        return blogRepository.save(blogAmendRequest.toEntity());
    }

    public Blog inquiryBlog(final Long id){
        return blogRepository.findById(id).orElseThrow(() -> new NotFoundBlogException(BAD_REQUEST, BlogConstant.NOT_FOUND_EXCEPTION.getMesage()));
    }

    public Blog updateBlog(final BlogAmendRequest blogAmendRequest){
        Blog inquiryBlog = inquiryBlog(blogAmendRequest.id());
        return inquiryBlog.update(blogAmendRequest);
    }
    
    public Blog patchBlog(final Long id, final BlogAmendRequest blogAmendRequest){
        Blog inquiryBlog = inquiryBlog(id);
        return inquiryBlog.patch(blogAmendRequest);
    }

    public void deleteBlog(final Long id){
        Blog inquiryBlog = inquiryBlog(id);
        blogRepository.delete(inquiryBlog);
    }

}
