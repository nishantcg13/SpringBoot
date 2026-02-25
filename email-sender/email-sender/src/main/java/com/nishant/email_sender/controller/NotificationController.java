package com.nishant.email_sender.controller;

import com.nishant.email_sender.dto.EmailDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController()
@RequestMapping("api/v1")
public class NotificationController {


    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/send-email")
    public String sendEmail(@ModelAttribute EmailDto emailDto) throws MessagingException, IOException {

//-------------this is used to send a plain email  --------------
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//
//        simpleMailMessage.setTo(emailDto.getTo());
//        simpleMailMessage.setSubject(emailDto.getSubject());
//        simpleMailMessage.setText(emailDto.getText());

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setTo(emailDto.getTo());
        mimeMessageHelper.setSubject(emailDto.getSubject());
        // if here u want to send the HTML code then u need to send a parameter 2 as true coz its
        // method has a parameter as true if HTML
        mimeMessageHelper.setText(emailDto.getText());
        mimeMessageHelper.addAttachment(emailDto.getAttachment().getOriginalFilename(), convertMultipartToFile(emailDto.getAttachment(),emailDto.getAttachment().getOriginalFilename()));

        javaMailSender.send(mimeMessage);

        return "Email Sent Successfully";
    }

    private static File convertMultipartToFile(MultipartFile multipartFile , String filename) throws IOException {

        // (System.getProperty("java.to.tmpdir")
        // this path give u the path of AppData/local/Temp/
        File convertedFile = new File(System.getProperty("java.io.tmpdir")+"/"+filename);
        multipartFile.transferTo(convertedFile);
        return convertedFile;

    }
}
