package com.example.study.exceptions;

/**
 * Exception to handle invalid Login
 *
 * @author Vinod John
 */
public class InvalidLoginException extends Exception {
    public InvalidLoginException(String username) {
        super("Invalid login credentials for username: " + username);
    }
}
