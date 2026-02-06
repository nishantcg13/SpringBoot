package com.nishant.blog_app_apis.services;

import com.nishant.blog_app_apis.payloads.PostDto;
import com.nishant.blog_app_apis.payloads.PostResponse;

import java.util.List;

public interface PostService {

    //create
    PostDto createPost(PostDto postDto, Integer userId , Integer categoryId);

    //update
    PostDto updatePost(PostDto postDto, Integer postId);

    //delete
    void deletePost(Integer postId);

    //getAll
    PostResponse getAllPost(Integer pageNumber , Integer pageSize , String sortBy , String sortDirection);

    //getSinglePost
    PostDto getPostById(Integer postId);

    // getAllPostsByCategory
    PostResponse getPostByCategory(Integer categoryId,Integer pageNumber , Integer pageSize);

    // getAllPostByUser
    PostResponse getPostByUser(Integer userId, Integer pageNumber , Integer pageSize);

    List<PostDto> searchPost(String keyword);
}
