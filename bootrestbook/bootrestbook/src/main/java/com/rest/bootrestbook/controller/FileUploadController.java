package com.rest.bootrestbook.controller;

import jakarta.annotation.Nonnull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {


    @PostMapping("/file")
    public ResponseEntity<String> fileUpload( @RequestParam("file")MultipartFile file) {


        //validation
        if(file.isEmpty()){
            return ResponseEntity.internalServerError().body("File should not be empty");
        }

        if(!file.getContentType().equals("image/jpeg")){
            return ResponseEntity.internalServerError().body("Only JPEG content type allowed");
        }

        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getName());

        return ResponseEntity.ok("File Uploaded Successfully");
    }

}
