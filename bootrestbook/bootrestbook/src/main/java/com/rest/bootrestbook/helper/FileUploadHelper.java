package com.rest.bootrestbook.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {


    //this is static path and it will give error when the pc or server will be changed to inorder to make it dynamic the
    // below line is given

//    public final String UPLOAD_DIR = "C:\\Users\\galan\\Desktop\\Spring Boot\\bootrestbook\\bootrestbook\\src\\main\\resources\\static\\image";
    public final String UPLOAD_DIR = new ClassPathResource("static/image").getFile().getAbsolutePath();
    //this will throw the exception so handle it in this class constructor

    FileUploadHelper() throws IOException {

    }



    public boolean uploadFile(MultipartFile file){
        boolean result = false;

        try{

//            //read
//            InputStream is = file.getInputStream();
//            byte data[] = new byte[is.available()];
//            is.read(data);
//
//            //write
//            FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+"\\"+file.getOriginalFilename());
//            // here we can use File.separator instead of "//" in the code
//
//            fos.write(data);
//            fos.flush();
//            fos.close();

            Files.copy(file.getInputStream(), Path.of(UPLOAD_DIR+ File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

            result = true;
        }catch(Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
