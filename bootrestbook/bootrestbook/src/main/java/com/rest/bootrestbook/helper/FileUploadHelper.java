package com.rest.bootrestbook.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

@Component
public class FileUploadHelper {

    public final String UPLOAD_DIR = "C:`\\`Users\\galan\\Desktop\\Spring Boot\\bootrestbook\\bootrestbook\\src\\main\\resources\\static\\image";


    public boolean uploadFile(MultipartFile file){
        boolean result = false;

        try{

            //read
            InputStream is = file.getInputStream();
            byte data[] = new byte[is.available()];
            is.read(data);

            //write
            FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+"\\"+file.getOriginalFilename());
            // here we can use File.separator instead of "//" in the code

            fos.write(data);
            fos.flush();
            fos.close();

            result = true;
        }catch(Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
