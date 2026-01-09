package com.rest.bootrestbook.controller;

import com.rest.bootrestbook.entity.Book;
import com.rest.bootrestbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@RestController
public class BookController {
 Scanner sc = new Scanner(System.in);

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> list = bookService.getAllBooks();
        return ResponseEntity.ok(list);
        // return ResponseEntity.ok(bookService.getAllBooks());  also a good coding practice
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
        return ResponseEntity.of(bookService.getBookById(id));
        // here we have 2 methods
    }

    // here we are making the same methods but the mapping is changed so remember that
    @PostMapping("/books")
    public String  addBook(@RequestBody Book book){
        String str = bookService.createBook(book);
        return str;
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        Optional<Book> deletedBook = bookService.deleteBook(id);
        if(deletedBook.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> update(@PathVariable("id") int id,@RequestBody Book book){
        return ResponseEntity.of(bookService.updateBook(id,book));
    }


}
