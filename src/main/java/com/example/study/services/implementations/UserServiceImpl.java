package com.example.study.services.implementations;

import com.example.study.models.User;
import com.example.study.repositories.UserRepository;
import com.example.study.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of UserService
 *
 * @author Vinod John
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean findUserByUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}
