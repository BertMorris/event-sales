package com.bertmorris.event_management.event.dto;

import java.time.LocalDate;

import com.bertmorris.event_management.event.EventStatus;

import jakarta.validation.constraints.NotNull;


public record EventCreateDto(
    @NotNull Long ownerId,
    @NotNull Long leadId,
    EventStatus status,
    Long eventTypeId,
    Long contactId,
    String company,
    LocalDate startDate,
    LocalDate endDate,
    Long venueId,
    Integer guests,
    Integer rooms
) {
}