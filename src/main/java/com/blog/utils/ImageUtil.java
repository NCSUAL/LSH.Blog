package com.blog.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.blog.dto.ImageDto;

public class ImageUtil {

    public static ImageDto toDto(MultipartFile file){
        final String uuidImageName = UUID.randomUUID().toString().concat(file.getName());
        return ImageDto.builder()
            .file(file)
            .contentType(file.getContentType())
            .fileName(uuidImageName)
            .encryptName(sha256Hex(uuidImageName))
            .build();
    }

    private static String sha256Hex(final String uuidImage){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = messageDigest.digest(uuidImage.getBytes(StandardCharsets.UTF_8));
            
            StringBuffer sb = new StringBuffer(bytes.length *2);

            for(byte b: bytes){
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
}
