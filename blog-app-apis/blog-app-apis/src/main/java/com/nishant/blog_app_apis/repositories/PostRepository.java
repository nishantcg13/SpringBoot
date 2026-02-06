package com.nishant.blog_app_apis.repositories;

import com.nishant.blog_app_apis.entites.Category;
import com.nishant.blog_app_apis.entites.Post;
import com.nishant.blog_app_apis.entites.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    Page<Post> findByUser(User user, Pageable pageable);
    Page<Post> findByCategory(Category category, Pageable pageable);

    List<Post> findByPostTitleContaining(String postTitle);
}
