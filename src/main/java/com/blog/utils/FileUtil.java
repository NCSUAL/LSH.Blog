package com.blog.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import com.blog.dto.ImageDto;

public class FileUtil {
    
    private final static String FILE_PATH = File.separator + "blogImage";

    public static void save(final ImageDto imageDto){
            try {
                Path path = Paths.get(FILE_PATH);

                if(!Files.exists(path)){
                    Files.createDirectories(path);
                }
                
                path.resolve(FILE_PATH.concat(File.separator).concat(imageDto.getFileName()));
                System.out.println(path.toString());
                imageDto.getFile().transferTo(path);
            } catch (IllegalStateException | IOException e) {
                // TODO Auto-generated catch block
                System.out.println(2);
                e.printStackTrace();
            } 
    }
}
