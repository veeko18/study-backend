package com.example.study.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * User model
 *
 * @author Vinod John
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;

    @OneToOne
    private School school;

    @OneToMany
    private List<Course> courses;
}

