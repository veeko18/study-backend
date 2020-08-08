package com.example.study.models;

import lombok.Data;

/**
 * User model
 *
 * @author Vinod John
 */

@Data
public class User {
    private Long id;
    private String username;
    private String password;
}
