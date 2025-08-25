package com.bertmorris.event_management.event.dto;

import java.util.Date;

import com.bertmorris.event_management.event.EventStatus;

import jakarta.validation.constraints.NotNull;

public record EventUpdateDto(
    @NotNull Long id,
    Long ownerId,
    Long leadId,
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

