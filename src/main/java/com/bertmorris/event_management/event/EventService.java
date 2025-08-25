package com.bertmorris.event_management.event;

import java.util.List;

import com.bertmorris.event_management.event.dto.EventCreateDto;
import com.bertmorris.event_management.event.dto.EventUpdateDto;

public interface EventService {

    Event getEventById(Long id);

    List<Event> getEvents();

    Event createEvent(EventCreateDto eventCreateDto);

    Event updateEvent(EventUpdateDto eventUpdateDto);

}