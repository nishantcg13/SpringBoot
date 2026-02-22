package com.nishant.blog_app_apis.controllers;

import com.nishant.blog_app_apis.config.AppConstants;
import com.nishant.blog_app_apis.payloads.ApiResponse;
import com.nishant.blog_app_apis.payloads.PostDto;
import com.nishant.blog_app_apis.payloads.PostResponse;
import com.nishant.blog_app_apis.services.FileService;
import com.nishant.blog_app_apis.services.PostService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PostController {


    @Autowired
    private PostService postService;

    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;

    //create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto,
                                              @PathVariable Integer userId,
                                              @PathVariable Integer categoryId) {
        PostDto createdPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);
    }

    //get by user
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<PostResponse> getPostByUser(@PathVariable Integer userId,
                                                      @RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
                                                      @RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize) {
        PostResponse posts = this.postService.getPostByUser(userId, pageNumber, pageSize);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    //get by category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<PostResponse> getPostByCategory(@PathVariable Integer categoryId,
                                                          @RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
                                                          @RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize) {
        PostResponse posts = this.postService.getPostByCategory(categoryId, pageNumber, pageSize);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    //get All post
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/post")
    public ResponseEntity<PostResponse> getAllPosts(@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
                                                    @RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
                                                    @RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
                                                    @RequestParam(value = "sortDirection", defaultValue = AppConstants.SORT_DIR, required = false) String sortDirection) {
        PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize, sortBy, sortDirection);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    //get post By ID
    @GetMapping("/post/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {
        PostDto postDto = this.postService.getPostById(postId);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    // delete post
    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Integer postId) {
        this.postService.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("Post deleted successfully", true), HttpStatus.OK);
    }

    // update post
    @PutMapping("/post/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {
        PostDto updatePost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<>(updatePost, HttpStatus.OK);
    }

    // searching
    @GetMapping("/post/search/{keywords}")
    public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable String keywords) {
        List<PostDto> postDtos = this.postService.searchPost(keywords);
        return new ResponseEntity<>(postDtos, HttpStatus.OK);
    }

    //post Image Upload
    @PostMapping("/post/image/upload/{postId}")
    public ResponseEntity<PostDto> uploadPostImage(@RequestParam("image") MultipartFile image, @PathVariable Integer postId) throws IOException {

        PostDto postDto = this.postService.getPostById(postId);

        String fileName = this.fileService.uploadImage(path, image);
        postDto.setPostImageName(fileName);
        PostDto updatePost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<>(updatePost, HttpStatus.OK);
    }

    //method to serve files
    @GetMapping(value = "/post/image/{imageName}", produces = MediaType.IMAGE_PNG_VALUE)
    public void downloadImage(
            @PathVariable String imageName, HttpServletResponse response) throws IOException {

        InputStream resource = this.fileService.getResource(path, imageName);
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        StreamUtils.copy(resource, response.getOutputStream());
    }

}
