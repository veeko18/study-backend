package com.example.study.controllers;

import com.example.study.models.School;
import com.example.study.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller to handle School requests
 *
 * @author Vinod John
 */
@Controller
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping
    public String showCreateSchoolPage(@ModelAttribute("school") School school,
                                       @ModelAttribute("message") String message,
                                       @ModelAttribute("messageType") String messageType) {
        return "school/create-school";
    }

    @PostMapping
    public String postSchool(School school, RedirectAttributes redirectAttributes) {
        boolean isSchoolExists = schoolService.findSchoolByName(school.getName()).isPresent();

        if (!isSchoolExists) {
            schoolService.createSchool(school);
            redirectAttributes.addFlashAttribute("message", "School created successfully!");
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("message", "School already exists!");
            redirectAttributes.addFlashAttribute("messageType", "error");
            return "redirect:/school";
        }
    }
}
