package com.nishant.cms.controller;


import com.nishant.cms.entity.OrderEntity;
import com.nishant.cms.entity.UserEntity;
import com.nishant.cms.repository.CmsRepository;
import com.nishant.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
