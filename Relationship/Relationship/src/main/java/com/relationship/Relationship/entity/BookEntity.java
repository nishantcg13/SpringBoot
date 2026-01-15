package com.relationship.Relationship.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "book")
public class BookEntity {

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private StudentEntity studentEntity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String bookName;
    private LocalDate carriedDate;
    private LocalDate returnDate;


    public BookEntity(){
        super();
    }

    public BookEntity(int bookId, String bookName,LocalDate carriedDate,LocalDate returnDate) {
        this.returnDate = returnDate;
        this.carriedDate = carriedDate;
        this.bookName = bookName;
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public LocalDate getCarriedDate() {
        return carriedDate;
    }

    public void setCarriedDate(LocalDate carriedDate) {
        this.carriedDate = carriedDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

}
