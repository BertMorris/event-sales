package com.bertmorris.event_management.event.dto;

import java.time.LocalDate;

import com.bertmorris.event_management.event.EventStatus;

import jakarta.validation.constraints.NotNull;

public record EventUpdateDto(
    @NotNull Long id,
    Long ownerId,
    Long leadId,
    EventStatus status,
    Long typeId,
    Long contactId,
    String company,
    LocalDate startDate,
    LocalDate endDate,
    Long venueId,
    Integer guests,
    Integer rooms
) {
}