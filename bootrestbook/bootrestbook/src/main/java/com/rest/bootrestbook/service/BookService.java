package com.rest.bootrestbook.service;

import com.rest.bootrestbook.entity.Book;
import com.rest.bootrestbook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
   // private static List<Book> list = new ArrayList<>();

//    static {
//        list.add(new Book(1, "Clean Code", "Robert C. Martin"));
//        list.add(new Book(2, "Effective Java", "Joshua Bloch"));
//        list.add(new Book(3, "Head First Java", "Kathy Sierra"));
//        list.add(new Book(4, "Java: The Complete Reference", "Herbert Schildt"));
//
//        list.add(new Book(5, "Learning Python", "Mark Lutz"));
//        list.add(new Book(6, "Fluent Python", "Luciano Ramalho"));
//
//        list.add(new Book(7, "You Don’t Know JS", "Kyle Simpson"));
//        list.add(new Book(8, "Eloquent JavaScript", "Marijn Haverbeke"));
//
//        list.add(new Book(9, "The C Programming Language", "Dennis Ritchie"));
//        list.add(new Book(10, "C++ Primer", "Stanley Lippman"));
//
//        list.add(new Book(11, "Design Patterns", "Erich Gamma"));
//        list.add(new Book(12, "Introduction to Algorithms", "Thomas H. Cormen"));
//    }

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
   public Optional<Book> getBookById(int id){
        return bookRepository.findById(id);
    }

    public Book createBook(Book b){
        Book result = bookRepository.save(b);
        return result;
    }

    public boolean deleteBook(int id) {
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Book> updateBook(int id , Book book){
        if(!bookRepository.existsById(id)){
            return Optional.empty();
        }
        book.setId(id);
        return Optional.of(bookRepository.save(book));

    }
}
