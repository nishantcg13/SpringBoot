package com.nishant.emailotp.service;

import com.nishant.emailotp.dto.RegisterDto;
import com.nishant.emailotp.entity.User;
import com.nishant.emailotp.repository.UserRepository;
import com.nishant.emailotp.util.EmailUtil;
import com.nishant.emailotp.util.OtpUtil;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.time.LocalDateTime;

public class UserService {

    @Autowired
    private OtpUtil otpUtil;

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private UserRepository userRepository;

    public String register(RegisterDto registerDto) {
       String otp = otpUtil.generateOtp();
        try {
            emailUtil.sendOtpEmail(registerDto.getEmail(),otp);
        } catch (MessagingException e) {
            throw new RuntimeException("Unable to send otp !! please try again");
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());
        user.setOtp(otp);
        user.setOtpGeneratedTime(LocalDateTime.now());

        userRepository.save(user);
        return "User Registration Successful";
    }

    public String verifyAccount(String email, String otp) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User Not Found with this email" + email));

        if(user.getOtp().equals(otp) && Duration.between(user.getOtpGeneratedTime(), LocalDateTime.now()).toSeconds() < (1*60)){
            user.setActive(true);
            return "Otp verified Successfully !! You can login";
        }
        return "Please "

    }
}
