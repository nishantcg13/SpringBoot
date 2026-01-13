package com.rest.bootrestbook.controller;

import com.rest.bootrestbook.helper.FileUploadHelper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @Autowired
    HttpServletRequest request;

    @PostMapping("/file")
    public ResponseEntity<String> fileUpload( @RequestParam("file")MultipartFile file) {

        try {


            //validation
            if (file.isEmpty()) {
                return ResponseEntity.internalServerError().body("File should not be empty");
            }

            if (!file.getContentType().equals("image/jpeg")) {
                return ResponseEntity.internalServerError().body("Only JPEG content type allowed");
            }

            //file upload code
            boolean result = fileUploadHelper.uploadFile(file);

            System.out.println(file.getOriginalFilename());
            System.out.println(file.getContentType());
            System.out.println(file.getSize());
            System.out.println(file.getName());

            if(result) {
//                return ResponseEntity.ok("File Uploaded Successfully");
//            now i want to return file-path to the user so
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromContextPath(request).path("/image/").path(file.getOriginalFilename()).toUriString());

            }else{
                return ResponseEntity.internalServerError().body("Something went wrong ... Try Again !!!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok("Working");
    }

}
