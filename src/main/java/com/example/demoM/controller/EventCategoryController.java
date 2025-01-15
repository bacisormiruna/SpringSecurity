package com.example.demoM.controller;

import com.example.demoM.model.EventCategory;
import com.example.demoM.service.category.EventCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("categories/")
@RequiredArgsConstructor
public class EventCategoryController {

    private final EventCategoryService eventCategoryService;

    @GetMapping
    public String displayAllCategories(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", eventCategoryService.getAllEventCategories());
        return "categories/index";
    }

    @GetMapping("createC")
    public String renderCreateCategoryForm(Model model) {
        model.addAttribute("title", "Create Category");
        model.addAttribute("categories", new EventCategory());
        return "categories/createC";
    }

    @PostMapping("createC")
    public String createCategory(@ModelAttribute @Valid EventCategory newCategory, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Category");
            return "categories/createC";
        }
        eventCategoryService.addCategory(newCategory);
        return "redirect:";
    }
}
