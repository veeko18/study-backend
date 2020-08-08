package com.example.study.services.implementations;

import com.example.study.components.DataInit;
import com.example.study.models.User;
import com.example.study.services.LoginService;
import org.springframework.stereotype.Service;

/**
 * Implementation of LoginService
 *
 * @author Vinod John
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public boolean isLoginValid(User user) {
        return DataInit.users.stream()
                .anyMatch(user1 -> user1.getUsername().equals(user.getUsername()) && user1.getPassword().equals(user.getPassword()));
    }
}
