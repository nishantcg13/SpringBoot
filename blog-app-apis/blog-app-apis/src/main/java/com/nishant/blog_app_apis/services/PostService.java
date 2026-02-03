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
    List<PostDto> getAllPost();

    //getSinglePost
    PostDto getPostById(Integer postId);

    // getAllPostsByCategory
    List<PostDto> getPostByCategory(Integer categoryId);

    // getAllPostByUser
    List<PostDto> getPostByUser(Integer userId);
}
