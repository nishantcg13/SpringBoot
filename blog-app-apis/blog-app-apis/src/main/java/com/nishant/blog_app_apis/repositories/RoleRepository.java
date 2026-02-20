package com.nishant.blog_app_apis.repositories;

import com.nishant.blog_app_apis.entites.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String name);
}
