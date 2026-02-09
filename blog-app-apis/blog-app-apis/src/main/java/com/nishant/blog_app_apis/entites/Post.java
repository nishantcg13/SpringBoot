package com.nishant.blog_app_apis.entites;

import com.nishant.blog_app_apis.services.CategoryService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post" , cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();
}
