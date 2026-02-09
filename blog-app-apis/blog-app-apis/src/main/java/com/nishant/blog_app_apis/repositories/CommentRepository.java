package com.nishant.blog_app_apis.repositories;

import com.nishant.blog_app_apis.entites.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository  extends JpaRepository<Comment , Integer> {

}
