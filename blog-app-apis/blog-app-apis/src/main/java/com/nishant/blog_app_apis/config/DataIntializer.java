package com.nishant.blog_app_apis.config;

import com.nishant.blog_app_apis.entites.Role;
import com.nishant.blog_app_apis.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataIntializer {
    
    @Bean
    public CommandLineRunner initializeRoles(RoleRepository roleRepository) {

        return args -> {

            if (roleRepository.findByName("ROLE_USER").isEmpty()) {

                Role userRole = new Role();
                userRole.setId(1);
                userRole.setName("ROLE_USER");

                roleRepository.save(userRole);
            }

            if (roleRepository.findByName("ROLE_ADMIN").isEmpty()) {

                Role adminRole = new Role();
                adminRole.setId(2);
                adminRole.setName("ROLE_ADMIN");

                roleRepository.save(adminRole);
            }

            System.out.println("Roles Initialized Successfully");
        };
    }

}
