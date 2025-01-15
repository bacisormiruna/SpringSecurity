package com.example.demoM.controller;

import com.example.demoM.dto.EventDto;
import com.example.demoM.mapper.EventMapper;
import com.example.demoM.model.Event;
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
    public String createEventForm(@RequestParam(value="eventSuccess", required = false) String success, Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute("eventSuccess", success);
        model.addAttribute("eventDto", new EventDto("","",""));
        return "createEvent";  // Asigură-te că ai un template createEvent.html
    }

    // Creează un eveniment nou
    @PostMapping("/createEvent")
    public String createEvent(@ModelAttribute("eventDto") EventDto eventDto, RedirectAttributes redirectAttributes) {
        Event event = eventMapper.eventDtoToEntity(eventDto);
        eventService.addEvent(event);

        // Adăugăm un flash attribute cu mesajul de succes
        redirectAttributes.addFlashAttribute("eventSuccess", "Eveniment creat cu succes!");

        // Redirecționăm către formularul de creare eveniment
        return "redirect:/createEvent";  // Se redirecționează înapoi la formularul de creare
    }
}

