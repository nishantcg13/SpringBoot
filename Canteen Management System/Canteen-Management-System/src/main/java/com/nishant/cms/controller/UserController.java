package com.nishant.cms.controller;


import com.nishant.cms.entity.OrderEntity;
import com.nishant.cms.entity.UserEntity;
import com.nishant.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/user/{userId}/orders")
    public ResponseEntity<List<OrderEntity>> getAllOrders(@PathVariable("userId") long id){
        List<OrderEntity> orders = userService.getAllOrdersOfUser(id);

        if(orders.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(orders);
    }
}
