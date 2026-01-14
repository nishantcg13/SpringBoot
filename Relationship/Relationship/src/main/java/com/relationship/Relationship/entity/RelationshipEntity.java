package com.relationship.Relationship.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "student")
public class RelationshipEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String name;

    private String bookName;

    public RelationshipEntity(){
        super();
    }
    public RelationshipEntity(int id, String name, String bookName) {
        this.id = id;
        this.name = name;
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "RelationshipEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bookName='" + bookName + '\'' +
                '}';
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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
