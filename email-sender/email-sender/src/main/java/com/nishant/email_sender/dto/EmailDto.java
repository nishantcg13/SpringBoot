package com.nishant.email_sender.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailDto {

    private String to;
    private String subject;
    private String text;

    private MultipartFile attachment;

}
