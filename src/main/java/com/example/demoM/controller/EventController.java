package com.example.demoM.controller;

import com.example.demoM.dto.EventDto;
import com.example.demoM.mapper.EventMapper;
import com.example.demoM.model.EventRequest;
import com.example.demoM.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String createEventForm(@RequestParam(value="eventSuccess", required=false) String success, Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute("eventSuccess", success); // Obiect gol pentru formular
        model.addAttribute("event", new EventRequest());
        return "createEvent"; // Template-ul pentru formularul de creare
    }

    @PostMapping("/createEvent")
    public String createEvent(@ModelAttribute("event") EventRequest eventRequest, RedirectAttributes redirectAttributes) {
        EventDto eventDto= eventService.registerEvent(eventRequest);
        redirectAttributes.addAttribute("eventSuccess", "Success");
            return "redirect:/eventsE"; // Redirecționare la lista evenimentelor după succes
    }
}

