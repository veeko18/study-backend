package com.example.study.services;

import com.example.study.models.Login;

/**
 * Service to handle login related operations
 *
 * @author Vinod John
 */
public interface LoginService {
    /**
     * To check whether the login is valid or not
     *
     * @param login login
     * @return true or false
     */
    boolean isLoginValid(Login login);
}
