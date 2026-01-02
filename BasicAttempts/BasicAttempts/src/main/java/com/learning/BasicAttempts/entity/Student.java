package com.learning.BasicAttempts.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private int Id;

    private String name;
    private int age;

    //Constructors

    public Student(){}

    public Student(String name,int age){
        this.name = name;
        this.age= age;
    }

    //GETTERS AND SETTERS
    public int getId(){
        return Id;
    }

    public void SetId(int Id){
        this.Id = Id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
}
