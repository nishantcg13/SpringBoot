package com.nishant.cms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CmsController{

    @RequestMapping("/test")
    public String test(){
        return "Hello This is Testing the application";
    }
}
