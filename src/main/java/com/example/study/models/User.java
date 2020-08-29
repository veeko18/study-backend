package com.example.study.models;

import lombok.Data;

import javax.persistence.*;

/**
 * User model
 *
 * @author Vinod John
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;

    @OneToOne(cascade = CascadeType.PERSIST)
    private School school;

    @OneToOne(cascade = CascadeType.MERGE)
    private Authority authority;

    /*
@OneToMany
private List<Course> courses;*/
}

