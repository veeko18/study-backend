package com.example.study.services.implementations;

import com.example.study.components.DataInit;
import com.example.study.models.User;
import com.example.study.services.UserService;
import org.springframework.stereotype.Service;

/**
 * Implementation of UserService
 *
 * @author Vinod John
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void createUser(User user) {
        user.setId(getNextUserIdSequence());
        DataInit.users.add(user);
    }

    @Override
    public boolean findUserByUsername(String username) {
        return DataInit.users.stream()
                .anyMatch(user -> user.getUsername().equals(username));
    }

    // PRIVATE METHODS //
    private Long getNextUserIdSequence() {
        return DataInit.users.size() + 1L;
    }
}
