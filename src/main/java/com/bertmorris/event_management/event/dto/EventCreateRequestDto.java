package com.bertmorris.event_management.event.dto;

import java.time.LocalDate;

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
    LocalDate startDate,
    LocalDate endDate,
    Long venueId,
    Integer guests,
    Integer rooms
) {
}