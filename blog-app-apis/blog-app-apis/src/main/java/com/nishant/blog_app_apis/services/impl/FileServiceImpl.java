package com.nishant.blog_app_apis.services.impl;

import com.nishant.blog_app_apis.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

        // Original filename
        String originalName = file.getOriginalFilename();

        // Generate unique filename
        String randomId = UUID.randomUUID().toString();
        String extension = originalName.substring(originalName.lastIndexOf("."));
        String fileName = randomId + extension;

        // Create directory if not exists
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();   // ✔ creates images folder
        }

        // Full file path
        String filePath = path + File.separator + fileName;

        // Copy file
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return fileName;
    }


    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath = path+File.separator+fileName;
        InputStream is = new FileInputStream(fullPath);
        return is;
    }
}
