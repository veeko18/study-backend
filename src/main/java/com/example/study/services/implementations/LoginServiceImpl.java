package com.example.study.services.implementations;

import com.example.study.models.Login;
import com.example.study.repositories.UserRepository;
import com.example.study.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of LoginService
 *
 * @author Vinod John
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isLoginValid(Login login) {
        return userRepository.findByUsernameAndPassword(login.getUsername(), login.getPassword()).isPresent();
    }
}
