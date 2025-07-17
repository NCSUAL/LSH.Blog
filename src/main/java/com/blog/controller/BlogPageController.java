package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.v3.oas.annotations.Hidden;

@Controller
@RequestMapping(value = "/")
public class BlogPageController {

    @RequestMapping(method = RequestMethod.GET)
    @Hidden
    public String index(){
        return "index";
    }
}
