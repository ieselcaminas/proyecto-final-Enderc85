package service;

import entity.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            return null;
        }

        return user;
    }

    public User register(String username) {

        if (username == null || username.isBlank()) {
            return null;
        }

        if (userRepository.findByUsername(username) != null) {
            return null;
        }

        User user = new User();
        user.setUsername(username);


        return userRepository.save(user);
    }

}
