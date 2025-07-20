package com.blog.dto;

import com.blog.domain.Image;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public final class ImageDto {
    private final String contentType;

    private final String fileName;

    private final String encryptName;

    public Image toEntity(){
        return Image.builder()
            .contentType(contentType)
            .fileName(fileName)
            .encryptName(encryptName)
            .build();
    }
}
