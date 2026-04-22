package org.example.proyectofinal.service;

import org.example.proyectofinal.entity.User;
import org.example.proyectofinal.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String username) {
        return userRepository.findByUsername(username);
    }

    public User register(String username) {
        if (username == null || username.isBlank()) return null;
        if (userRepository.findByUsername(username) != null) return null;

        User user = new User();
        user.setUsername(username);
        return userRepository.save(user);
    }
}
