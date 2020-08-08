package com.example.study;

import com.example.study.models.User;
import com.example.study.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class StudyApplication implements CommandLineRunner {
    @Autowired
    private LoginService loginService;

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Welcome to study app!");
        login();
    }

    private void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username");
        String username = scanner.next();

        System.out.println("Enter password");
        String password = scanner.next();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if(loginService.isLoginValid(user)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid login! Please try again:");
            login();
        }

    }
}
