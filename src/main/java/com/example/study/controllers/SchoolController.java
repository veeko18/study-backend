package com.example.study.controllers;

import com.example.study.models.School;
import com.example.study.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/create")
    public String showCreateSchoolPage(@ModelAttribute("school") School school,
                                       @ModelAttribute("message") String message,
                                       @ModelAttribute("messageType") String messageType) {
        return "school/create-school";
    }

    @PostMapping
    public String createSchool(School school, RedirectAttributes redirectAttributes) {
        boolean isSchoolExists = schoolService.findSchoolByName(school.getName()).isPresent();

        if (!isSchoolExists) {
            schoolService.createSchool(school);
            redirectAttributes.addFlashAttribute("message", "School created successfully!");
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/school";
        } else {
            redirectAttributes.addFlashAttribute("message", "School already exists!");
            redirectAttributes.addFlashAttribute("messageType", "error");
            return "redirect:/school/create";
        }
    }

    @GetMapping
    public String showSchoolList(Model model) {
        model.addAttribute("schools", schoolService.getAllSchools());
        return "school/list-school";
    }

    @GetMapping("/update")
    public String showUpdateSchoolPage(@ModelAttribute("school") School school,
                                       @ModelAttribute("message") String message,
                                       @ModelAttribute("messageType") String messageType) {
        return "school/update-school";
    }

    @PostMapping("/update")
    public String updateSchool(School school, RedirectAttributes redirectAttributes) {
        boolean isSchoolExists = schoolService.findSchoolById(school.getId()).isPresent();

        if (isSchoolExists) {
            schoolService.updateSchool(school);
            redirectAttributes.addFlashAttribute("message", "School updated successfully!");
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/school";
        } else {
            redirectAttributes.addFlashAttribute("message", "School not found!");
            redirectAttributes.addFlashAttribute("messageType", "error");
            return "redirect:/school/create";
        }
    }
}
