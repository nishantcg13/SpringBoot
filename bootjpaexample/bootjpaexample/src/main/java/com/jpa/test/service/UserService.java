package com.jpa.test.service;

import com.jpa.test.Repository.UserRepository;
import com.jpa.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@ResponseBody
public class UserService {
    @Autowired
    private UserRepository repo;

    public String addStudent(){

        User user = new User();

        user.setName("Nishant");
        user.setAge(22);
        user.setStatus("Java Programmer");

       repo.save(user);

        return "User successfully added";
    }

}
