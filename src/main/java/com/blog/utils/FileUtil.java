package com.blog.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.controller.ImageController;
import com.blog.dto.ImageDto;

import lombok.Getter;

public class FileUtil {
    
    //파일 경로
    private final static String FILE_PATH = File.separator + "blogImage" + File.separator;

    //이미지 요청 API
    @Getter
    private final static String IMAGE_REQUEST_API = 
        Optional.ofNullable(ImageController.class.getAnnotation(RequestMapping.class))
            .map(instance -> Arrays.stream(instance.value()).findAny().orElseThrow(()-> new UnsupportedOperationException("개발중입니다.")))
            .orElseThrow(() -> new UnsupportedOperationException("개발중입니다.")).concat(File.separator);

    public static void save(final ImageDto imageDto){
            try {
                Path path = Paths.get(FILE_PATH);

                if(!Files.exists(path)){
                    Files.createDirectories(path);
                }

                Path filePath = path.resolve(FILE_PATH.concat(File.separator).concat(imageDto.getFileName()));
                System.out.println(filePath.toString());

                imageDto.getFile().transferTo(filePath);
            } catch (IllegalStateException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
    }

    public static Optional<byte[]> load(final String uuidImageName){
        try {
            Path path = Paths.get(FILE_PATH)
            .resolve(uuidImageName);

            byte[] readBytes = Files.readAllBytes(path);

            return Optional.of(readBytes);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            return Optional.empty();
        }

    } 
}
