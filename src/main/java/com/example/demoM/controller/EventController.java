package com.example.demoM.controller;

import com.example.demoM.dto.EventDto;
import com.example.demoM.mapper.EventMapper;
import com.example.demoM.model.EventRequest;
import com.example.demoM.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("events", eventsDto);
        return "eventsE";
    }

    @GetMapping("/eventsE/{id}")
    public EventDto getEventById(@PathVariable Integer id){
        return eventService.getEventById(id);
    }


    @GetMapping("/createEvent")
    public String createEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute("eventRequest", new EventRequest()); // Obiect gol pentru formular
        return "createEvent"; // Template-ul pentru formularul de creare
    }

    @PostMapping("/createEvent")
    public String createEvent(@ModelAttribute("eventRequest") EventRequest eventRequest, Model model) {
        try {
            eventService.registerEvent(eventRequest);
            return "redirect:/eventsE"; // Redirecționare la lista evenimentelor după succes
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while creating the event.");
            model.addAttribute("eventRequest", eventRequest);
            return "createEvent"; // Înapoi la formular dacă apare o eroare
        }
    }
}

