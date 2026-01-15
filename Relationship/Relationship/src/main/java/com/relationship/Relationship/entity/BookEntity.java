package com.relationship.Relationship.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "book")
public class BookEntity {

    private int bookId;
    private String bookName;
    private LocalDate carriedDate;
    private LocalDate returnDate;

    BookEntity(){
        super();
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
