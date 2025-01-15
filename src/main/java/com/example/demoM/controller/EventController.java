package com.example.demoM.controller;

import com.example.demoM.dto.EventDto;
import com.example.demoM.mapper.EventMapper;
import com.example.demoM.model.Event;
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
        List<Event> events = eventService.getAllEvents();
        model.addAttribute("title", "Events");
        model.addAttribute("events", eventMapper.eventListEntityToDto(events)); // Aici se adaugă lista corect mapată
        return "eventsE"; // Asigură-te că fișierul este numit corect
    }

    @GetMapping("/eventsE/{id}")
    public EventDto getEventById(@PathVariable Integer id){
        return eventService.getEventById(id);
    }
}

    // Endpoint pentru adăugarea unui eveniment
   /* @GetMapping("/eventsE/add")
    public String showAddEventForm(Model model) {
        model.addAttribute("title", "Add Event");
        model.addAttribute("event", new Event());
        return "create";  // Pagina de adăugare eveniment
    }

    @PostMapping("/events/add")
    public String addEvent(@ModelAttribute("event") Event event, RedirectAttributes redirectAttributes) {
        eventService.addEvent(event);  // Adăugăm evenimentul
        redirectAttributes.addAttribute("eventAdded", "Event added successfully.");
        return "redirect:/eventsE";  // După ce se adaugă, redirecționăm la lista de evenimente
    }

    // Endpoint pentru ștergerea unui eveniment
    @GetMapping("/events/delete/{id}")
    public String deleteEvent(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            eventService.deleteEvent(id);
            redirectAttributes.addAttribute("eventDeleted", "Event deleted successfully.");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addAttribute("eventDeleteError", "Event not found.");
        }
        return "redirect:/eventsE";  // După ce se șterge, redirecționăm la lista de evenimente
    }

    // Endpoint pentru vizualizarea unui eveniment după ID
    @GetMapping("/events/{id}")
    public String getEventById(@PathVariable("id") Integer id, Model model) {
        eventService.getEventById(id).ifPresent(event -> model.addAttribute("event", eventMapper.eventEntityToDto(event)));
        model.addAttribute("title", "Event Details");
        return "eventDetails";  // Pagina detaliilor evenimentului
    }*/
