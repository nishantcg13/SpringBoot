package com.nishant.blog_app_apis.controllers;

import com.nishant.blog_app_apis.entites.Post;
import com.nishant.blog_app_apis.payloads.ApiResponse;
import com.nishant.blog_app_apis.payloads.PostDto;
import com.nishant.blog_app_apis.payloads.PostResponse;
import com.nishant.blog_app_apis.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //get by user
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<PostResponse> getPostByUser(@PathVariable Integer userId, @RequestParam(value = "pageNumber" , defaultValue = "0" , required = false)Integer pageNumber , @RequestParam(value = "pageSize" , defaultValue = "5",required = false)Integer pageSize){
        PostResponse posts= this.postService.getPostByUser(userId, pageNumber , pageSize);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    //get by category
    @GetMapping("category/{categoryId}/posts")
    public ResponseEntity<PostResponse> getPostByCategory(@PathVariable Integer categoryId , @RequestParam(value = "pageNumber" , defaultValue = "0" , required = false)Integer pageNumber, @RequestParam(value = "pageSize" , defaultValue = "5" , required = false)Integer pageSize){
        PostResponse posts= this.postService.getPostByCategory(categoryId, pageNumber, pageSize);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    //get All post
    @GetMapping("/post")
    public ResponseEntity<PostResponse> getAllPosts(@RequestParam(value = "pageNumber" , defaultValue = "0",required = false) Integer pageNumber,
                                                    @RequestParam(value = "pageSize" , defaultValue = "5",required = false) Integer pageSize,
                                                    @RequestParam(value = "sortBy", defaultValue = "postId",required = false)String sortBy ,
                                                    @RequestParam(value = "sortDirection" , defaultValue = "asc" , required = false) String sortDirection){
        PostResponse postResponse= this.postService.getAllPost(pageNumber, pageSize,sortBy, sortDirection);
        return new ResponseEntity<>(postResponse,HttpStatus.OK);
    }

    //get post By ID
    @GetMapping("/post/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
        PostDto postDto = this.postService.getPostById(postId);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    // delete post
    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("Post deleted successfully",true),HttpStatus.OK);
    }

    // update post
    @PutMapping("post/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId){
        PostDto updatePost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<>(updatePost,HttpStatus.OK);
    }

    // searching
    @GetMapping("/posts/search/{keywords}")
    public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable String keywords){
        List<PostDto> postDtos = this.postService.searchPost(keywords);

    }
}
