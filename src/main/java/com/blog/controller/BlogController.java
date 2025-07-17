package com.blog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.ApiEntity;
import com.blog.dto.response.BlogResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/blog")
@RequiredArgsConstructor
public class BlogController {

    @RequestMapping(method = RequestMethod.GET)
    public ApiEntity<List<BlogResponse>> getAllBlogsWithBlogResponse(){
        
    }
}
