package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.service.BlogService;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class BlogPageController {

    private final BlogService blogService;

    @RequestMapping(method = RequestMethod.GET)
    @Hidden
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @Hidden
    public String list(Model model){
        model.addAttribute("datas", blogService.inquiryAllBlogs());
        return "list";
    }
}
