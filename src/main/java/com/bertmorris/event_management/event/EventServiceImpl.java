package com.bertmorris.event_management.event;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bertmorris.event_management.contact.ContactService;
import com.bertmorris.event_management.event.dto.EventCreateDto;
import com.bertmorris.event_management.event.dto.EventUpdateDto;
import com.bertmorris.event_management.event.type.EventType;
import com.bertmorris.event_management.event.type.EventTypeRepository;
import com.bertmorris.event_management.user.UserService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EventServiceImpl implements EventService {

    

    private final EventRepository eventRepository;
    private final EventTypeRepository eventTypeRepository;
    private final UserService userService;
    private final ContactService contactService;


    public EventServiceImpl(EventRepository eventRepository, EventTypeRepository eventTypeRepository, UserService userService, ContactService contactService) {
        this.eventRepository = eventRepository;
        this.eventTypeRepository = eventTypeRepository;
        this.userService = userService;
        this.contactService = contactService;
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Event not found"));
    }

    @Override
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event createEvent(EventCreateDto eventCreateDto) {
        Event event = new Event();
       
       event.setOwner(userService.getUserById(eventCreateDto.ownerId()));
       event.setLead(leadService.getLeadById(eventCreateDto.leadId()));
       event.setStatus(eventCreateDto.status() != null ? eventCreateDto.status() : EventStatus.PROSPECT);

       if (eventCreateDto.eventTypeId() != null) {
        event.setType(getEventTypeById(eventCreateDto.eventTypeId()));
       }

       if (eventCreateDto.contactId() != null) {
        event.setContact(contactService.getContactById(eventCreateDto.contactId()));
       }
       
       if (eventCreateDto.company() != null) {
        event.setCompany(eventCreateDto.company());
       }

       if (eventCreateDto.startDate() != null) {
        event.setStartDate(eventCreateDto.startDate());
       }

       if (eventCreateDto.endDate() != null) {
        event.setEndDate(eventCreateDto.endDate());
       }

       if (eventCreateDto.venueId() != null) {
        event.setVenue(venueService.getVenueById(eventCreateDto.venueId()));
       }

       if (eventCreateDto.guests() != null) {
        event.setGuests(eventCreateDto.guests());
       }

       if (eventCreateDto.rooms() != null) {
        event.setRooms(eventCreateDto.rooms());
       }

        return eventRepository.save(event);
    }
    
    @Override
    public Event updateEvent(EventUpdateDto eventUpdateDto) {
        Event event = getEventById(eventUpdateDto.id());

        if (eventUpdateDto.ownerId() != null) {
            event.setOwner(userService.getUserById(eventUpdateDto.ownerId()));
        }

        if (eventUpdateDto.leadId() != null) {
            event.setLead(leadService.getLeadById(eventUpdateDto.leadId()));
        }

        if (eventUpdateDto.status() != null) {
            event.setStatus(eventUpdateDto.status());
        }

        if (eventUpdateDto.eventTypeId() != null) {
            event.setType(getEventTypeById(eventUpdateDto.eventTypeId()));
        }

        if (eventUpdateDto.contactId() != null) {
            event.setContact(contactService.getContactById(eventUpdateDto.contactId()));
        }

        if (eventUpdateDto.company() != null) {
            event.setCompany(eventUpdateDto.company());
        }

        if (eventUpdateDto.startDate() != null) {
            event.setStartDate(eventUpdateDto.startDate());
        }

        if (eventUpdateDto.endDate() != null) {
            event.setEndDate(eventUpdateDto.endDate());
        }

        if (eventUpdateDto.venueId() != null) {
            event.setVenue(venueService.getVenueById(eventUpdateDto.venueId()));
        }

        if (eventUpdateDto.guests() != null) {
            event.setGuests(eventUpdateDto.guests());
        }

        if (eventUpdateDto.rooms() != null) {
            event.setRooms(eventUpdateDto.rooms());
        }

        return eventRepository.save(event);
    }

    private EventType getEventTypeById(Long id) {
        return eventTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Event type not found"));
    }
}
