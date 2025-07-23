package com.blog.dto.response;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.blog.domain.Image;
import com.blog.utils.FileUtil;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class ImageResponse {
    private final String url;

    public static ImageResponse of(final Image image){
        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(FileUtil.getIMAGE_REQUEST_API())
                .path(image.getEncryptName())
                .toUriString();

        return ImageResponse.builder()
            .url(url)
            .build();
    }
}
