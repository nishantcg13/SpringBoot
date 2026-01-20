package com.nishant.cms.service;

import com.nishant.cms.entity.OrderEntity;
import com.nishant.cms.entity.UserEntity;
import com.nishant.cms.repository.CmsRepository;
import com.nishant.cms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//UserService
//→ manages user data
//→ create user, update user, find user
//

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CmsRepository cmsRepository;

    public String createUser(UserEntity userEntity){
        userRepository.save(userEntity);
        return "User Created Successfully";
    }

    public List<OrderEntity> getAllOrdersOfUser(long id){
        return cmsRepository.findByUserId(id);
    }

}
