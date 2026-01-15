package com.relationship.Relationship.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "student")
public class StudentEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "studentEntity")
    @JsonManagedReference
    private List<BookEntity> bookEntity;

    public StudentEntity(){
        super();
    }
    public StudentEntity(int id, String name, List<BookEntity> bookEntity) {
        this.id = id;
        this.name = name;
        this.bookEntity = bookEntity;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books='" + bookEntity + '\'' +
                '}';
    }

    public List<BookEntity> getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(List<BookEntity> bookEntity) {
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
