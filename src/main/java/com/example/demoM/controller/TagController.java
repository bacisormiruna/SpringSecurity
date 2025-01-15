package com.example.demoM.controller;

import com.example.demoM.model.Tag;
import com.example.demoM.service.tag.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("tags/")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;
    @GetMapping
    public String displayTags(Model model){
        model.addAttribute("title", "All Tags");
        model.addAttribute("tags", tagService.getAllTags());
        return "tags/index";
    }

    @GetMapping("create")
    public String displayCreateTagForm(Model model){
        model.addAttribute("title", "Create Tags");
        model.addAttribute(new Tag());
        return "tags/create";
    }

    @PostMapping("create")
    public String processCreateTagForm(@ModelAttribute @Valid Tag tag, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Create Tag");
            model.addAttribute(tag);
            return "tags/create";
        }
        if (!tag.getName().startsWith("#")) {
            tag.setName("#" + tag.getName().trim());
        }
        tagService.addTag(tag);
        return "redirect:";
    }
    @GetMapping("{tagId}/events")
    public String displayEventsByTag(@PathVariable Integer tagId, Model model) {
        Optional<Tag> result = Optional.ofNullable(tagService.getTagById(tagId));

        if (result.isPresent()) {
            Tag tag = result.get();
            model.addAttribute("title", "Events with tag: " + tag.getName());
            model.addAttribute("events", tag.getEvents());
        } else {
            model.addAttribute("title", "Invalid Tag ID: " + tagId);
            model.addAttribute("events", null);
        }

        return "tags/events";
    }

    @GetMapping("/tags/update/{name}")
    public String showUpdateForm(@PathVariable("name") String name, Model model) {
        Tag tag = tagService.getTagByName(name);
        if (tag != null) {
            model.addAttribute("tag", tag);
            return "tags/update"; // Numele paginii Thymeleaf pentru update
        } else {
            return "redirect:/tags"; // Redirecționează dacă tag-ul nu este găsit
        }
    }

    @PostMapping("/tags/update")
    public String updateTag(@ModelAttribute @Valid Tag tag, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("tag", tag);
            return "tags/update"; // Reafișează formularul cu erori
        }
        tagService.updateTag(tag); // Salvează tag-ul actualizat
        return "redirect:/tags"; // Redirecționează la lista de tag-uri
    }
}

