package com.nishant.blog_app_apis.services.impl;

import com.nishant.blog_app_apis.entites.Comment;
import com.nishant.blog_app_apis.entites.Post;
import com.nishant.blog_app_apis.exceptions.ResourceNotFoundException;
import com.nishant.blog_app_apis.payloads.CommentDto;
import com.nishant.blog_app_apis.repositories.CommentRepository;
import com.nishant.blog_app_apis.repositories.PostRepository;
import com.nishant.blog_app_apis.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {

        Post post = this.postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));

        Comment comment = this.dtoToComment(commentDto);

        comment.setPost(post);

        Comment savedComment = this.commentRepository.save(comment);

        return this.commentToDto(savedComment);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));


    }

    public CommentDto commentToDto(Comment comment) {
        CommentDto commentDto = this.modelMapper.map(comment, CommentDto.class);
        return commentDto;
    }

    public Comment dtoToComment(CommentDto commentDto) {
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        return comment;
    }
}
