package com.nishant.blog_app_apis;

import com.nishant.blog_app_apis.config.AppConstants;
import com.nishant.blog_app_apis.entites.Role;
import com.nishant.blog_app_apis.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class BlogAppApisApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BlogAppApisApplication.class, args);
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.passwordEncoder.encode("xyz"));

        try {

            Role role = new Role();
            role.setId(AppConstants.ROLE_ADMIN);
            role.setName("ROLE_ADMIN");

            Role role1 = new Role();
            role1.setId(AppConstants.ROLE_USER);
            role1.setName("ROLE_USER");

            List<Role> roles = List.of(role, role1);

            List<Role> result = this.roleRepository.saveAll(roles);

            result.forEach(r -> {
                System.out.println(r.getName());
            });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
