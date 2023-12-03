package com.blogserver.configurations;

import com.blogserver.repositories.BlogRepository;
import com.blogserver.repositories.UserRepository;
import com.blogserver.services.AuthenticationService;
import com.blogserver.services.BlogService;
import com.blogserver.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    public AuthenticationService authenticationService(UserRepository userRepository) {
        return new AuthenticationService(userRepository);
    }

    @Bean
    public BlogService blogService(BlogRepository blogRepository) {
        return new BlogService(blogRepository);
    }
}
