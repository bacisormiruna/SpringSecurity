package com.example.demoM.service.event;

import com.example.demoM.dto.EventDto;
import com.example.demoM.mapper.EventMapper;
import com.example.demoM.model.Event;
import com.example.demoM.model.EventRequest;
import com.example.demoM.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public List<EventDto> getAllEvents() {
        return eventMapper.eventListEntityToDto(eventRepository.findAll());
    }

    @Override
    public EventDto registerEvent(EventRequest eventRequest) {
        // Creăm un eveniment pe baza cererii de înregistrare
        Event event = Event.builder()
                .name(eventRequest.getName())
                .eventCategory(eventRequest.getEventCategory())  // presupun că ai un câmp pentru categorie
                .eventDetails(eventRequest.getEventDetails())    // presupun că ai un câmp pentru detalii
                .build();
        return this.addEvent(event); // folosim metoda addEvent pentru a salva evenimentul
    }

    @Override
    public EventDto addEvent(Event event) {
        // Salvăm evenimentul în baza de date
        Event savedEvent = eventRepository.save(event);
        // Returnăm evenimentul salvat sub formă de DTO
        return eventMapper.eventEntityToDto(savedEvent);
    }

    @Override
    public EventDto getEventById(Integer id) {
        // Găsim evenimentul după ID
        return eventRepository.findById(id)
                .map(eventMapper::eventEntityToDto)
                .orElseThrow(() -> new IllegalArgumentException("Event with ID " + id + " does not exist."));
    }

    @Override
    public EventDto updateEvent(Integer id, EventDto eventDto) {
        // Căutăm evenimentul după ID
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Event with ID " + id + " does not exist."));

        // Actualizăm câmpurile evenimentului existent
        existingEvent.setName(eventDto.name());
        existingEvent.setEventCategory(eventDto.eventCategory());
        existingEvent.setEventDetails(eventDto.eventDetails());

        // Salvăm evenimentul actualizat
        Event updatedEvent = eventRepository.save(existingEvent);

        // Returnăm evenimentul actualizat sub formă de DTO
        return eventMapper.eventEntityToDto(updatedEvent);
    }

    @Override
    public void deleteEvent(Integer id) {
        // Verificăm dacă evenimentul există și îl ștergem
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Event with ID " + id + " does not exist.");
        }
    }
}