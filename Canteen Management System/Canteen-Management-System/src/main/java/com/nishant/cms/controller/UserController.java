package com.nishant.cms.controller;


import com.nishant.cms.entity.UserEntity;
import com.nishant.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //CREATE THE USER
    @PostMapping("/create")
    public String create(@RequestBody UserEntity userEntity){
        return userService.createUser(userEntity);
    }

}
