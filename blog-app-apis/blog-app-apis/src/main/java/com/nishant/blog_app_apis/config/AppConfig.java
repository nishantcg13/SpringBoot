package com.nishant.blog_app_apis.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class AppConfig {

    @Bean
    public UserDetailsService userDetailService() {

        UserDetails user1 = User.builder().username("nishant").password("password").roles("ADMIN").build();
        UserDetails user2 = User.builder().username("nishant").password("password").roles("ADMIN").build();
        UserDetails user3 = User.builder().username("nishant").password("password").roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user3);

    }


}
