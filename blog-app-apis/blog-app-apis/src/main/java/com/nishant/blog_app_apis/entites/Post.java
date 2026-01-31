package com.nishant.blog_app_apis.entites;

import com.nishant.blog_app_apis.services.CategoryService;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    private String postTitle;

    // content length
    @Column(length = 10000)
    private String postContent;

    private String postImageName;

    private Date postAddedDate;

    @ManyToOne
    //itha variable name tithe mappedBy madhe liha
    private Category category;

    @ManyToOne
    private User user;
}
