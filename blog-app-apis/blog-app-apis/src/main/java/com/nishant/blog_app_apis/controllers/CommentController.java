package com.nishant.blog_app_apis.controllers;


import com.nishant.blog_app_apis.payloads.ApiResponse;
import com.nishant.blog_app_apis.payloads.CommentDto;
import com.nishant.blog_app_apis.services.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> deleteComment(@Valid @RequestBody CommentDto commentDto, @PathVariable Integer postId){

        CommentDto createdComment = this.commentService.createComment(commentDto, postId);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){

        this.commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponse>( new ApiResponse("Comment Deleted Successfully", true), HttpStatus.OK);
    }
}
