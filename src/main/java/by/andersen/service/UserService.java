package by.andersen.service;

import by.andersen.entity.User;
import by.andersen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUserWithCreds(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Long lastId = userRepository.getLatestUserId();
        user.setId(lastId + 1);
        userRepository.saveUser(user);
    }
}
