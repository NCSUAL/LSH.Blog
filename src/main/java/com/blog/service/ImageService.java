package com.blog.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.blog.domain.Image;
import com.blog.dto.ImageDto;
import com.blog.exception.image.ImageNotFoundException;
import com.blog.repository.ImageRepository;
import com.blog.utils.FileUtil;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ImageService {

    private final ImageRepository imageRepository;

    public Image uploadImage(final ImageDto imageDto){  
        //파일 저장
        FileUtil.save(imageDto);
        return imageRepository.save(imageDto.toEntity());
    }

    public Image inquiryImageByEncryptName(final String encryptName){
        return imageRepository.findByEncryptName(encryptName).orElseThrow(() -> new ImageNotFoundException(HttpStatus.BAD_REQUEST, encryptName));
    }
}
