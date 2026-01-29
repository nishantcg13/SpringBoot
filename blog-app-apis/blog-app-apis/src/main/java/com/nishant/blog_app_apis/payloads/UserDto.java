package com.nishant.blog_app_apis.payloads;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int userId;

    @NotBlank
    @Size(min =3, max = 15, message = "Username must be min of 4 characters")
    private String userName;

    @Email(message = "Please enter a valid email")
    private String userEmail;

    @NotBlank(message = "Password must not be empty")
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
            message = "Password must be minimum 8 chars with letters & numbers"
    )
    private String userPassword;

    @NotBlank(message = "About must not be empty")
    private String userAbout;

}