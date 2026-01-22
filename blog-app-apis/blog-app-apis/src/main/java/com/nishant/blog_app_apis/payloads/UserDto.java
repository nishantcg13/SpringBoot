package com.nishant.blog_app_apis.payloads;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userAbout;

}