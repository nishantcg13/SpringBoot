package com.learning.BasicAttempts.controller;

import com.learning.BasicAttempts.entity.Student;
import com.learning.BasicAttempts.repository.Studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private Studentrepository repo;

    @GetMapping("/add")
    @ResponseBody
    public String addStudent() {

        Student s = new Student();
        s.setName("Nishant");
        s.setAge(22);

        repo.save(s);   // ORM INSERT happens here

        return "Student inserted successfully";
    }
}
