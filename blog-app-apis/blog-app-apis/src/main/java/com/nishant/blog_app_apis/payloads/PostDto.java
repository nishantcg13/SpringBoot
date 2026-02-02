package com.nishant.blog_app_apis.payloads;

import com.nishant.blog_app_apis.entites.Category;
import com.nishant.blog_app_apis.entites.User;

import java.util.Date;

public class PostDto {
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;

    private Category category;
    private User user;
}
