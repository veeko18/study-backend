package com.example.study.services;

import com.example.study.models.User;

import java.util.List;
import java.util.Optional;

/**
 * Service to handle user related operations
 *
 * @author Vinod John
 */
public interface UserService {

    /**
     * To create a new user
     *
     * @param user User
     */
    void createUser(User user);

    /**
     * To find user by username
     *
     * @param username User's username
     * @return Optional of User
     */
    Optional<User> findUserByUsername(String username);

    /**
     * To find user by username and password
     *
     * @param username User's username
     * @param password User's username
     * @return Optional of user
     */
    Optional<User> findByUsernameAndPassword(String username, String password);

    /**
     * To get all users
     *
     * @return list of users
     */
    List<User> getAllUsers();
}
