package com.nishant.emailotp.controller;

import com.nishant.emailotp.dto.RegisterDto;
import com.nishant.emailotp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){

        return new ResponseEntity<>(userService.register(registerDto), HttpStatus.OK);
    }

    @PutMapping("/verifyAccount-account")
    public ResponseEntity<String> verify(@RequestParam String email,@RequestParam String otp){
        return new ResponseEntity<>(userService.verifyAccount(email,otp),HttpStatus.OK);
    }



}
