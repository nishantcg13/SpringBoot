package com.jpa.test.controller;

import com.jpa.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/users")
public class UserController {

    
    @Autowired
    private UserService Uservice;

    @GetMapping("/test")
    public String test(){
        return "Testing Successful";
    }


    @PostMapping("/add")
    public String addUser(){
        return Uservice.addStudent();
    };

}
