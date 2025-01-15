package com.example.demoM.controller;

import com.example.demoM.model.Event;
import com.example.demoM.model.EventCategory;
import com.example.demoM.repository.EventCategoryRepository;
import com.example.demoM.repository.EventRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("events")
public class EventController {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @GetMapping
    public String displayAllEvents(@RequestParam(required = false) Integer categoryId, Model model){
        if (categoryId==null) {
            model.addAttribute("title", "All Events");
            model.addAttribute("events", eventRepository.findAll());
        }else{
            Optional<EventCategory> result = eventCategoryRepository.findById(categoryId);
            if (result.isEmpty()){
                model.addAttribute("title", "Invalid Category ID: " + categoryId);
            }
            else{
                EventCategory category = result.get();
                model.addAttribute("title","Events in category: " + category.getName());
                model.addAttribute("events", category.getEvents());
            }
        }
        return "events/index";
    }

    @GetMapping("create")
    public String renderCreateEventForm(Model model){
        model.addAttribute("title","Create Event");
        model.addAttribute(new Event());
        model.addAttribute("category",eventCategoryRepository.findAll());
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@ModelAttribute @Valid Event newEvent, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Create Event");
            return "events/create";
        }

        eventRepository.save(newEvent);
        return "redirect:/events";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events",eventRepository.findAll());
        return "events/delete";
    }
    @PostMapping("delete")
    public String deleteEvents(@RequestParam(required=false) int[] eventIds) {
        if(eventIds!=null){
            for (int id : eventIds) {
                eventRepository.deleteById(id);
            }
        }
        return "redirect:/events";
    }
    @GetMapping("detail")
    public String displayEventDetails(@RequestParam Integer eventId, Model model){
        Optional<Event> result = eventRepository.findById(eventId);
        if (result.isEmpty()){
            model.addAttribute("title", "Invalid Event ID:" + eventId);
        }else{
            Event event = result.get();
            model.addAttribute("title", event.getName()+ "Details");
            model.addAttribute("event", event);
            model.addAttribute("tags", event.getTags());
        }
        return "events/detail";
    }
   /* @GetMapping("add-tag")
    public String displayAddTagForm(@RequestParam Integer eventId, Model model){
        Optional<Event> result =eventRepository.findById(eventId);
        Event event= result.get();
        model.addAttribute("title", "Add Tag to: " + event.getName());
        model.addAttribute("tags", tagRepository.findAll());
        EventTagDTO eventTag = new EventTagDTO();
        eventTag.setEvent(event);
        model.addAttribute("eventTag",eventTag);
        return "events/add-tag.html";
    }

    @PostMapping("add-tag")
    public String processAddTagForm(@ModelAttribute @Valid EventTagDTO eventTag, Errors errors, Model model) {
        if (!errors.hasErrors()) {
            Optional<Event> eventResult = eventRepository.findById(eventTag.getEvent().getId());
            Optional<Tag> tagResult = tagRepository.findById(eventTag.getTag().getId());

            if (eventResult.isPresent() && tagResult.isPresent()) {
                Event event = eventResult.get();
                Tag tag = tagResult.get();
                if (!event.getTags().contains(tag)) {
                    event.addTag(tag);
                    eventRepository.save(event);
                }
            }

            return "redirect:detail?eventId=" + eventTag.getEvent().getId();
        }
        return "redirect:add-tag";
    }
}*/
}