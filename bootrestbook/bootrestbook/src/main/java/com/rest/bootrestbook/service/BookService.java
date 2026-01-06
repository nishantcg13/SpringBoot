package com.rest.bootrestbook.service;

import com.rest.bootrestbook.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(1, "Clean Code", "Robert C. Martin"));
        list.add(new Book(2, "Effective Java", "Joshua Bloch"));
        list.add(new Book(3, "Head First Java", "Kathy Sierra"));
        list.add(new Book(4, "Java: The Complete Reference", "Herbert Schildt"));

        list.add(new Book(5, "Learning Python", "Mark Lutz"));
        list.add(new Book(6, "Fluent Python", "Luciano Ramalho"));

        list.add(new Book(7, "You Don’t Know JS", "Kyle Simpson"));
        list.add(new Book(8, "Eloquent JavaScript", "Marijn Haverbeke"));

        list.add(new Book(9, "The C Programming Language", "Dennis Ritchie"));
        list.add(new Book(10, "C++ Primer", "Stanley Lippman"));

        list.add(new Book(11, "Design Patterns", "Erich Gamma"));
        list.add(new Book(12, "Introduction to Algorithms", "Thomas H. Cormen"));
    }

    public List<Book> getAllBooks(){
        return list;
    }
   public Optional<Book> getBookById(int id){
        for(Book book : list){
            if(book.getId() == id){
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    public String createBook(Book b){
        list.add(b);
        return b.toString()+"added successfully";
    }

    public Optional<Book> deleteBook(int id) {

        Iterator<Book> itr = list.iterator();

        while(itr.hasNext()){
            Book b = itr.next();
            if(b.getId() == id){
                itr.remove();
                return Optional.of(b);
            }
        }
        return Optional.empty();
    }

    public void updateBook(int id , Book book){
        Iterator<Book> itr = list.iterator();
        while(itr.hasNext()){
            Book newBook = itr.next();
            if(newBook.getId() == id){
                newBook.setTitle(book.getTitle());
                newBook.setAuthor(book.getAuthor());
                return;
            }
        }
    }
}
