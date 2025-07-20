package com.blog.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.blog.dto.ApiEntity;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/image")
public class ImageController {

    @RequestMapping(method = RequestMethod.POST)
    public ApiEntity<?> uploadImage(@RequestParam("image") MultipartFile image){
        System.out.println(image.getContentType());
        System.out.println(image.getName());
        System.out.println(UUID.randomUUID());
        ServletUriComponentsBuilder.fromCurrentContextPath().path(null).build().to
        return ApiEntity.ok("test");
    }
}
