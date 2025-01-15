package com.example.demoM.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class TagController {
   /* TagRepository tagRepository;
    @GetMapping
    public String displayTags(Model model){
        model.addAttribute("title", "All Tags");
        model.addAttribute("tags", tagRepository.findAll());
        return "tags/index";
    }*/

  /*  @GetMapping("create")
    public String displayCreateTagForm(Model model){
        model.addAttribute("title", "Create Tags");
        model.addAttribute(new Tag());
        return "tags/create";
    }*/

   /* @PostMapping("create")
    public String processCreateTagForm(@ModelAttribute @Valid Tag tag, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Create Tag");
            model.addAttribute(tag);
            return "tags/create";
        }
        if (!tag.getName().startsWith("#")) {
            tag.setName("#" + tag.getName().trim());
        }
        tagRepository.save(tag);
        return "redirect:/tags";
    }*/
   /* @GetMapping("{tagId}/events")
    public String displayEventsByTag(@PathVariable Integer tagId, Model model) {
        Optional<Tag> result = tagRepository.findById(tagId);

        if (result.isPresent()) {
            Tag tag = result.get();
            model.addAttribute("title", "Events with tag: " + tag.getName());
            model.addAttribute("events", tag.getEvents());
        } else {
            model.addAttribute("title", "Invalid Tag ID: " + tagId);
            model.addAttribute("events", null);
        }

        return "tags/events";
    }*/
}
