package com.nishant.cms.service;

import com.nishant.cms.entity.UserEntity;
import com.nishant.cms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public String createUser(UserEntity userEntity){
        userRepository.save(userEntity);
        return "User Created Successfully";
    }

}
