package com.firstproject.BasicFirstProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @GetMapping("/home")
    public String home(){
        System.out.println("The web page will show here Hello World !!!!");
        return "home.html";
    }
}
