package com.blogserver.services;

import com.blogserver.dataobjects.UserRecord;
import com.blogserver.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public boolean addUser(UserRecord user) {
        if (!assertEmailExists(user.getEmail())) {
             userRepository.save(user);
             return true;
        } else {
            throw new IllegalArgumentException("Account with this email already exists");
        }
    }

    public List<UserRecord> getUsers() {
        return (List<UserRecord>) userRepository.findAll();
    }

    public boolean assertEmailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

}
