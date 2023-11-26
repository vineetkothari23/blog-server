package com.blogserver.configurations;

import com.blogserver.repositories.UserRepository;
import com.blogserver.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public UserService userService(UserRepository userRepository){
        return new UserService(userRepository);
    }
}
