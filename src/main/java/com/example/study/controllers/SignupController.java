package com.example.study.controllers;

import com.example.study.models.User;
import com.example.study.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller to handle signup related requests
 *
 * @author Vinod John
 */
@Controller
@RequestMapping("/signup")
public class SignupController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String showSignupPage(@ModelAttribute("user") User user, @ModelAttribute("message") String message,
                                 @ModelAttribute("messageType") String messageType) {
        return "auth/signup";
    }

    @PostMapping
    public String postLogin(User user, RedirectAttributes redirectAttributes) {
        boolean isUserExists = userService.findUserByUsername(user.getUsername()).isPresent();

        if (!isUserExists) {
            userService.createUser(user);
            redirectAttributes.addFlashAttribute("message", "Signup successful!");
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("message", "User already exists!");
            redirectAttributes.addFlashAttribute("messageType", "error");
            return "redirect:/signup";
        }
    }
}
