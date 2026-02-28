package com.nishant.emailotp.controller;

import com.nishant.emailotp.dto.LoginDto;
import com.nishant.emailotp.dto.RegisterDto;
import com.nishant.emailotp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){

        return new ResponseEntity<>(userService.register(registerDto), HttpStatus.OK);
    }

    @PutMapping("/verify-account")
    public ResponseEntity<String> verify(@RequestParam String email,@RequestParam String otp){
        return new ResponseEntity<>(userService.verifyAccount(email,otp),HttpStatus.OK);
    }

    @PutMapping("/regenerate-otp")
    public ResponseEntity<String> regenerateOtp(@RequestParam String email){
        return new ResponseEntity<>(userService.regenerateOtp(email),HttpStatus.OK);
    }

    @PutMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        return new ResponseEntity<>(userService.login(loginDto),HttpStatus.OK);
    }
}
