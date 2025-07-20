package com.blog.service;

import org.springframework.stereotype.Service;

import com.blog.domain.Image;
import com.blog.dto.ImageDto;
import com.blog.repository.ImageRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ImageService {

    private final ImageRepository imageRepository;

    public Image uploadImage(final ImageDto imageDto){
        return imageRepository.save(imageDto.toEntity());
    }

    public Image inquiryImageByEncryptName(final String encryptName){
        return imageRepository.findByEncryptName(encryptName).orElseThrow(() -> )
    }
}
