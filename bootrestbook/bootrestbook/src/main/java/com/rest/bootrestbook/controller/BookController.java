package com.rest.bootrestbook.controller;

import com.rest.bootrestbook.entity.Book;
import com.rest.bootrestbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@RestController
public class BookController {
 Scanner sc = new Scanner(System.in);

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/bookid/{id}")
    public Book getBookById(@PathVariable("id") int id){
        return bookService.getBookById(id);
    }
}
