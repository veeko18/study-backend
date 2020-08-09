package com.example.study.controllers;

import com.example.study.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller to handle all user related requests
 *
 * @author Vinod John
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String showAllUserPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/user-list";
    }
}
