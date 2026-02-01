package com.nishant.blog_app_apis.repositories;

import com.nishant.blog_app_apis.entites.Category;
import com.nishant.blog_app_apis.entites.Post;
import com.nishant.blog_app_apis.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
