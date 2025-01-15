package com.example.demoM.controller;

import com.example.demoM.dto.EventDto;
import com.example.demoM.mapper.EventMapper;
import com.example.demoM.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final EventMapper eventMapper;  // Injectăm mapper-ul pentru conversia obiectelor


    @GetMapping("/eventsE")
    public String getAllEvents(Model model, Authentication authentication) {
        List<EventDto> eventsDto = eventService.getAllEvents();
        model.addAttribute("title", "Events");
        model.addAttribute("events", eventsDto); // Aici se adaugă lista corect mapată
        return "eventsE";
    }

    @GetMapping("/eventsE/{id}")
    public EventDto getEventById(@PathVariable Integer id){
        return eventService.getEventById(id);
    }
}

