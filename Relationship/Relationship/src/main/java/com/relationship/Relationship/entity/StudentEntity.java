package com.relationship.Relationship.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "student")
public class StudentEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private BookEntity bookEntity;

    public StudentEntity(){
        super();
    }
    public StudentEntity(int id, String name, BookEntity bookEntity) {
        this.id = id;
        this.name = name;
        this.bookEntity = bookEntity;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bookName='" + bookEntity + '\'' +
                '}';
    }

    public BookEntity getBookName() {
        return bookEntity;
    }

    public void setBookName(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
