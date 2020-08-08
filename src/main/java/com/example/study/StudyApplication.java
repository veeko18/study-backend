package com.example.study;

import com.example.study.models.User;
import com.example.study.services.LoginService;
import com.example.study.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class StudyApplication implements CommandLineRunner {
    @Autowired
    private LoginService loginService;

    private static final String INVALID_OPTION = "Invalid option! Please try again!";
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }

    @Override
    public void run(String... args) {
        displayMenu();
        processMenu();
    }

    private void displayMenu() {
        System.out.println("1.Login\n2.Signup\n3.Exit\n Choose one option from the above:");
    }

    private void processMenu() {
        try {
            Scanner scanner = new Scanner(System.in);
            int menuOption = scanner.nextInt();

            switch (menuOption) {
                case 1:
                    login();
                    break;
                case 2:
                    signup();
                    login();
                    break;
                case 3:
                    break;
                default:
                    System.out.println(INVALID_OPTION);
                    processMenu();
            }
        } catch (Exception e) {
            System.out.println(INVALID_OPTION);
            processMenu();
        }
    }

    private void login() {
        User user = getUserInput();
        if (loginService.isLoginValid(user)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid login! Please try again:");
            login();
        }
    }

    private void signup() {
        User user = getUserInput();

        if (userService.findUserByUsername(user.getUsername())) {
            System.out.println("Username already exists! Please signup with other user or Login");
            run();
        } else {
            userService.createUser(user);
            System.out.println("Signup successful! Please login:");
        }
    }

    private User getUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username");
        String username = scanner.next();

        System.out.println("Enter password");
        String password = scanner.next();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        return user;
    }
}
