package com.blog.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.blog.common.CRUD.*;
import com.blog.constant.BlogConstant;
import com.blog.dto.ApiEntity;
import com.blog.dto.request.blog.BlogAmendRequest;
import com.blog.dto.response.BlogResponse;
import com.blog.service.BlogService;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @RequestMapping(method = RequestMethod.POST)
    public ApiEntity<BlogResponse> postBlog(@Validated(Create.class) @JsonView(Create.class) @RequestBody BlogAmendRequest blogAmendRequest){
        return ApiEntity.ok(BlogResponse.of(blogService.createBlog(blogAmendRequest)));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ApiEntity<List<BlogResponse>> getAllBlogs(){
        return ApiEntity.ok(blogService.inquiryAllBlogs()
                .stream()
                .map(BlogResponse::of)
                .toList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ApiEntity<BlogResponse> getBlog(@PathVariable(value = "id") Long id){
        return ApiEntity.ok(BlogResponse.of(blogService.inquiryBlog(id)));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ApiEntity<BlogResponse> putBlog(@Validated(Update.class) @JsonView(Update.class) @RequestBody BlogAmendRequest blogAmendRequest){
        return ApiEntity.ok(BlogResponse.of(blogService.updateBlog(blogAmendRequest)));
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PATCH)
    public ApiEntity<BlogResponse> patchBlog(@PathVariable(value = "id") Long id,@Validated(Patch.class) @JsonView(Patch.class) @RequestBody BlogAmendRequest blogAmendRequest){
        return ApiEntity.ok(BlogResponse.of(blogService.patchBlog(id, blogAmendRequest)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ApiEntity<String> deleteBlog(@PathVariable(value = "id") Long id){
        blogService.deleteBlog(id);
        return ApiEntity.ok(BlogConstant.SUCCESS_DELETE.getMesage());
    }
    
}
