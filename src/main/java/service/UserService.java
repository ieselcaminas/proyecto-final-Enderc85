package service;

import entity.User;
import repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String username) {
        return userRepository.findByUsername(username);
    }

    public void register(User user) {
        userRepository.save(user);
    }
}
