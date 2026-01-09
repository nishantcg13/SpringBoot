package com.rest.bootrestbook.repository;

import com.rest.bootrestbook.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {
    
    public Optional<Book> findById(int id);
}
