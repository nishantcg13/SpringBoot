package com.nishant.emailotp.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OtpUtil {

    public String generateOtp(){
        Random random = new Random();
        int randomNumber = random.nextInt(999999); // 6 digit so i have 6 times 9

        StringBuilder otp = new StringBuilder(Integer.toString(randomNumber));

        // here we applied while loop coz if the random function gave us number as 001234 then it will
        // look like this 1234 while conversion so we are adding the trailing 0's
        while (otp.length() < 6){
            otp.insert(0, "0");
        }
        return otp.toString();
    }

}
