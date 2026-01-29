package com.nishant.blog_app_apis.repositories;

import com.nishant.blog_app_apis.entites.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category , Integer> {
}
