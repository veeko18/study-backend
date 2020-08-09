package com.example.study.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller to handle home related requests
 *
 * @author Vinod John
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String showHomePage() {
        return "home";
    }
}
