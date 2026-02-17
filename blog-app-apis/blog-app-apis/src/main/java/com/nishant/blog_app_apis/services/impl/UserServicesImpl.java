package com.nishant.blog_app_apis.services.impl;

import com.nishant.blog_app_apis.entites.User;
import com.nishant.blog_app_apis.exceptions.ResourceNotFoundException;
import com.nishant.blog_app_apis.payloads.UserDto;
import com.nishant.blog_app_apis.repositories.UserRepository;
import com.nishant.blog_app_apis.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServicesImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = this.dtoToUser(userDto);
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        User savedUser = this.userRepository.save(user);

        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        // Exception(resourceName , fieldName , fieldValue)
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

        user.setName(userDto.getUserName());
        user.setEmail(userDto.getUserEmail());
        user.setUserPassword(userDto.getUserPassword());
        user.setUserAbout(userDto.getUserAbout());

        User updatedUser = this.userRepository.save(user);
        return userToDto(updatedUser);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUserById(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        return this.userToDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers() {

        List<User> users = this.userRepository.findAll();
        List<UserDto> userDto = users.stream().map(user -> this.userToDto(user)).toList();
        return userDto;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

        userRepository.delete(user);

    }

    // now the problem here is we will need to send the data to userRepository in the class named User
    // but here we are using UserDto so we will need to change the object means set the fields in the
    // User by getting the fields in the UserDto

    private User dtoToUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);

//        user.setUserName(userDto.getUserName());
//        user.setEmail(userDto.getEmail());
//        user.setUserPassword(userDto.getUserPassword());
//        user.setUserAbout(userDto.getUserAbout());

        return user;
    }

    private UserDto userToDto(User user) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);

//        userDto.setUserId(user.getUserId());
//        userDto.setUserName(user.getUserName());
//        userDto.setEmail(user.getEmail());
//        userDto.setUserPassword(user.getUserPassword());
//        userDto.setUserAbout(user.getUserAbout());

        return userDto;
    }
}
