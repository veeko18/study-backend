package com.example.study.components;

import com.example.study.models.User;
import com.example.study.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Init component
 *
 * @author Vinod John
 */
@Component
public class DataInit {
    public static final List<User> users = new ArrayList<>();

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initData() {
        initUserData();
    }

    // PRIVATE METHODS //
    private void initUserData() {
        User user = new User();
        user.setUsername("vinodjohn");
        user.setPassword("123456");
        userService.createUser(user);
    }
}
