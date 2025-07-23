package com.blog.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blog.domain.Image;
import com.blog.dto.ApiEntity;
import com.blog.dto.response.ImageResponse;
import com.blog.service.ImageService;
import com.blog.utils.FileUtil;
import com.blog.utils.ImageUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/image")
public class ImageController {

    private final ImageService imageService;

    @RequestMapping(method = RequestMethod.POST)
    public ApiEntity<ImageResponse> uploadImage(@RequestParam("image") MultipartFile image){
        Image uploadEntity = imageService.uploadImage(ImageUtil.toDto(image));
        return ApiEntity.ok(ImageResponse.of(uploadEntity));
    }

    @RequestMapping(value = "/{path}",method = RequestMethod.GET)
    public ResponseEntity<byte[]> loadImage(@PathVariable(value = "path") final String path){
        Image inquiryImage = imageService.inquiryImageByEncryptName(path);
        byte[] image = FileUtil.load(inquiryImage.getFileName()).orElseThrow(()-> new UnsupportedOperationException("구현중입니다."));
        return ResponseEntity.ok()
            .body(image);
    }

}
