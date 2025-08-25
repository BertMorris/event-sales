package com.bertmorris.event_management.event.dto;

import java.util.Date;

import com.bertmorris.event_management.event.EventStatus;

import jakarta.validation.constraints.NotNull;


public record EventCreateDto(
    @NotNull Long ownerId,
    @NotNull Long leadId,
    EventStatus status,
    Long eventTypeId,
    Long contactId,
    String company,
    Date startDate,
    Date endDate,
    Long venueId,
    Integer guests,
    Integer rooms
) {
    
}