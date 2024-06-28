package com.crowd.Donation.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Struct;

@Service
public class FileService {

    public String uploadImage(String path, MultipartFile file) throws IOException {

        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());

        // Generate a unique filename using timestamp
        String uniqueFileName = System.currentTimeMillis() + "_" + originalFilename;

        // Construct the file path
        String filePath = path + File.separator + uniqueFileName;
        File file1 = new File(path);

        if(!file1.exists()){
            file1.mkdir();
        }
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return uniqueFileName;

    }

}
