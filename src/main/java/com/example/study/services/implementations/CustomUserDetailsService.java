package com.example.study.services.implementations;

import com.example.study.models.User;
import com.example.study.services.CustomUserDetails;
import com.example.study.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Customized implementation of UserDetailsService
 *
 * @author Vinod John
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userService.findUserByUsername(username);

        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User not exists with username: " + username);
        }

        return new CustomUserDetails(optionalUser.get());
    }
}
