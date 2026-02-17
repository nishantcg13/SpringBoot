package com.nishant.blog_app_apis.entites;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtRequest {

    private String email;

    private String password;
}
