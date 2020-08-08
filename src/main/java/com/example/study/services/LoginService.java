package com.example.study.services;

import com.example.study.models.User;

/**
 * Service to handle login related operations
 *
 * @author Vinod John
 */
public interface LoginService {
    /**
     * To check whether the login is valid or not
     *
     * @param user User
     * @return true or false
     */
    boolean isLoginValid(User user);
}
