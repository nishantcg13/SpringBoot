package com.nishant.blog_app_apis.controllers;

import com.nishant.blog_app_apis.payloads.PostDto;
import com.nishant.blog_app_apis.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class PostController {


    @Autowired
    private PostService postService;

    //create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto, @PathVariable Integer userId , @PathVariable Integer categoryId){
        PostDto createdPost =  this.postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<PostDto>(createdPost , HttpStatus.CREATED);
    }
}
