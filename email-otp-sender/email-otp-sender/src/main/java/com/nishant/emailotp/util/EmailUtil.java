package com.nishant.emailotp.util;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendOtpEmail(String email, String otp) throws MessagingException {
        System.out.println("Inside sendOtpEmail method");
        System.out.println("Sending OTP to: " + email);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("Verify Otp");
        String content = String.format("""
        <div>
        <a href="http://localhost:8080/verify-account?email=%s&otp=%s" target="_blank">
        Click link to verify Account
        </a>
        </div>
        """, email, otp);

        mimeMessageHelper.setText(content, true); // true = HTML
        javaMailSender.send(mimeMessage);
        System.out.println("About to send mail...");
        System.out.println("Mail sent successfully");
    }

}
