package com.nishant.blog_app_apis.repositories;

import com.nishant.blog_app_apis.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByEmail(String email);
}
