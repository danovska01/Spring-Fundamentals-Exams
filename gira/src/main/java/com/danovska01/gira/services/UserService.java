package com.danovska01.gira.services;

import com.danovska01.gira.models.User;
import com.danovska01.gira.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Add other methods as needed, such as createUser, updateUser, deleteUser, etc.
}
