package com.example.demoM.controller;

import com.example.demoM.dto.EventTagDto;
import com.example.demoM.model.Event;
import com.example.demoM.model.EventCategory;
import com.example.demoM.model.Tag;
import com.example.demoM.service.category.EventCategoryService;
import com.example.demoM.service.event.EventService;
import com.example.demoM.service.tag.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("events/")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final EventCategoryService eventCategoryService;
    private final TagService tagService;
    @GetMapping
    public String displayAllEvents(@RequestParam(required=false) Integer categoryId, Model model){

        if(categoryId == null) {
            model.addAttribute("title", "All Events");
            model.addAttribute("events", eventService.getAllEvents());
        }
        else {
            EventCategory result = eventCategoryService.getEventById(categoryId);
            if (result == null){
                model.addAttribute("title", "Invalid Category Id " + categoryId);
            }
            else {
                model.addAttribute("title", "Events in category: " + result.getName());
                model.addAttribute("events", result.getEvents());
            }
        }
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model){
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event()); // this empty event will have inf about the event so it will be helpful for the create template ( asa am putut inlocui name si type attributes cu th:field...)
        model.addAttribute("categories", eventCategoryService.getAllEventCategories());
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model){ // in errors vor fi scrise toate mesajele de eroare de la validare

        if(errors.hasErrors()){
            model.addAttribute("title", "Create Event");
            model.addAttribute("categories", eventCategoryService.getAllEventCategories());
            return "events/create";
        }

        eventService.createEvent(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", eventService.getAllEvents());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds){ // pentru a nu primi eroare cand nu avem selectat niciun eveniment

        if (eventIds != null) {
            for (int id : eventIds) {
                eventService.deleteEventById(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("detail")
    public String displayEventDetails(@RequestParam Integer eventId, Model model){
        Event event = eventService.getEventById(eventId);

        if (event == null){
            model.addAttribute("title", "Invalid Event ID: " + eventId);
        }
        else {
            model.addAttribute("title", event.getName() + " Details");
            model.addAttribute("event", event);
        }

        return "events/detail";
    }

    @GetMapping("add-tag")
    public String displayAddTagForm(@RequestParam Integer eventId, Model model){
        Optional<Event> result = Optional.ofNullable(eventService.getEventById(eventId));
        Event event= result.get();
        model.addAttribute("title", "Add Tag to: " + event.getName());
        model.addAttribute("tags", tagService.getAllTags());
        EventTagDto eventTag = new EventTagDto();
        eventTag.setEvent(event);
        model.addAttribute("eventTag",eventTag);
        return "events/add-tag";
    }

    @PostMapping("add-tag")
    public String processAddTagForm(@ModelAttribute @Valid EventTagDto eventTag, Errors errors, Model model) {
        if (!errors.hasErrors()) {
            Optional<Event> eventResult = Optional.ofNullable(eventService.getEventById(eventTag.getEvent().getId()));
            Optional<Tag> tagResult = Optional.ofNullable(tagService.getTagById(eventTag.getTag().getId()));

            if (eventResult.isPresent() && tagResult.isPresent()) {
                Event event = eventResult.get();
                Tag tag = tagResult.get();
                if (!event.getTags().contains(tag)) {
                    event.addTag(tag);
                    eventService.addEvent(event);
                }
            }

            return "redirect:detail?eventId=" + eventTag.getEvent().getId();
        }
        return "redirect:";
    }

}