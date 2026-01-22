package com.nishant.blog_app_apis.services.impl;

import com.nishant.blog_app_apis.entites.User;
import com.nishant.blog_app_apis.exceptions.ResourceNotFoundException;
import com.nishant.blog_app_apis.payloads.UserDto;
import com.nishant.blog_app_apis.repositories.UserRepository;
import com.nishant.blog_app_apis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServicesImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepository.save(user);

        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        // Exception(resourceName , fieldName , fieldValue)
        User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User" , "userId", userId ));

        user.setUserName(userDto.getUserName());
        user.setUserEmail(userDto.getUserEmail());
        user.setUserPassword(userDto.getUserPassword());
        user.setUserAbout(userDto.getUserAbout());

        User updatedUser = this.userRepository.save(user);
        UserDto userDto1 = userToDto(updatedUser);
        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    // now the problem here is we will need to send the data to userRepository in the class named User
    // but here we are using UserDto so we will need to change the object means set the fields in the
    // User by getting the fields in the UserDto

    private User dtoToUser(UserDto userDto){
        User user = new User();

        user.setUserId(userDto.getUserId());
        user.setUserName(userDto.getUserName());
        user.setUserEmail(userDto.getUserEmail());
        user.setUserPassword(userDto.getUserPassword());
        user.setUserAbout(userDto.getUserAbout());

        return user;
    }

    private UserDto userToDto(User user){
        UserDto userDto = new UserDto();

        userDto.setUserId(user.getUserId());
        userDto.setUserName(user.getUserName());
        userDto.setUserEmail(user.getUserEmail());
        userDto.setUserPassword(user.getUserPassword());
        userDto.setUserAbout(user.getUserAbout());

        return userDto;
    }
}
