package com.nishant.blog_app_apis.services;

import com.nishant.blog_app_apis.entites.Post;
import com.nishant.blog_app_apis.payloads.PostDto;

import java.util.List;

public interface PostService {

    //create
    PostDto createPost(PostDto postDto, Integer userId , Integer categoryId);

    //update
    PostDto updatePost(PostDto postDto, Integer postId);

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
