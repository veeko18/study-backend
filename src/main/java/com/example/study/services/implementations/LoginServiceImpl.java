package com.example.study.services.implementations;

import com.example.study.exceptions.InvalidLoginException;
import com.example.study.models.Login;
import com.example.study.models.User;
import com.example.study.services.LoginService;
import com.example.study.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of LoginService
 *
 * @author Vinod John
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserService userService;

    @Override
    public void validateLogin(Login login) throws InvalidLoginException {
        Optional<User> userOptional = userService.findByUsernameAndPassword(login.getUsername(), login.getPassword());

        if (userOptional.isEmpty()) {
            throw new InvalidLoginException(login.getUsername());
        }
    }
}
