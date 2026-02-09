package com.nishant.blog_app_apis.services;

import com.nishant.blog_app_apis.payloads.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto , Integer postId);

    void deleteComment(Integer commentId);
}
