package com.nishant.blog_app_apis.services;

import com.nishant.blog_app_apis.entites.Post;
import com.nishant.blog_app_apis.payloads.PostDto;

import java.util.List;

public interface PostService {

    //create
    Post createPost(PostDto postDto);

    //update
    Post updatePost(PostDto postDto, Integer postId);

    //delete
    void deletePost(Integer postId);

    //getAll
    List<Post> getAllPost();

    //getSinglePost
    Post getPostById(Integer postId);

    // getAllPostsByCategory
    List<Post> getPostByCategory(Integer categoryId);

    // getAllPostByUser
    List<Post> getPostByUser(Integer userId);
}
