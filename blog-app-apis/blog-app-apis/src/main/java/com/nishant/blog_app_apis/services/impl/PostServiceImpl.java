package com.nishant.blog_app_apis.services.impl;

import com.nishant.blog_app_apis.entites.Post;
import com.nishant.blog_app_apis.payloads.PostDto;
import com.nishant.blog_app_apis.repositories.PostRepository;
import com.nishant.blog_app_apis.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepositor;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Post createPost(PostDto postDto) {

        return null;
    }

    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<Post> getAllPost() {
        return List.of();
    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getPostByCategory(Integer categoryId) {
        return List.of();
    }

    @Override
    public List<Post> getPostByUser(Integer userId) {
        return List.of();
    }


    //conversions
    private Post dtoToPost(PostDto postDto){
        Post post = this.modelMapper.map(postDto, Post.class);
        return post;
    }

    private PostDto postToDto(Post post){
        PostDto postDto = this.modelMapper.map(post,PostDto.class);
        return postDto;
    }
}
