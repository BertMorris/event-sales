package com.bertmorris.event_management.event.dto;

import java.util.Date;

import com.bertmorris.event_management.event.EventStatus;
import com.bertmorris.event_management.event.type.EventType;

import jakarta.validation.constraints.NotNull;

public record EventCreateRequestDto(
    @NotNull Long ownerId,
    @NotNull Long leadId,
    EventStatus status,
    EventType type,
    Long contactId,
    String company,
    Date startDate,
    Date endDate,
    Long venueId,
    Integer guests,
    Integer rooms
) {
}