package com.nishant.blog_app_apis.repositories;

import com.nishant.blog_app_apis.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
