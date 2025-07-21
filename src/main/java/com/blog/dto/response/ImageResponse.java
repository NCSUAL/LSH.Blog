package com.blog.dto.response;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.blog.domain.Image;

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
                .path(image.getEncryptName())
                .toString();

        return ImageResponse.builder()
            .url(url)
            .build();
    }
}
