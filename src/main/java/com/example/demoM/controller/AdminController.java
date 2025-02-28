package com.example.demoM.controller;

import com.example.demoM.model.User;
import com.example.demoM.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    @GetMapping
    public String adminPage(Model model) {
        model.addAttribute("title", "Admin Panel");
        model.addAttribute("users", userService.getAllUsers());
        return "admin/index"; // O pagină HTML pentru admin
    }

    @GetMapping("createUserAdmin")
    public String showAddUserForm(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute(new User());
        return "admin/createUserAdmin"; // O pagină HTML pentru formularul de adăugare
    }

    // Salvarea utilizatorului nou
    @PostMapping("createUserAdmin")
    public String addUser(@ModelAttribute @Valid User user, Errors errors, Model model) {
        userService.createUser(user);
        return "redirect:/admin/index"; // Redirect la pagina admin
    }
}
