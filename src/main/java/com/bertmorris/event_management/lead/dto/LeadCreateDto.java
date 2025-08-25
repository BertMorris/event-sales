package com.bertmorris.event_management.lead.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public record LeadCreateDto(
    String company,
    String title,
    String description,
    Integer budget,
    LocalDate date,
    Integer guests,
    Integer rooms,
    @NotNull Long ownerId, // going with ids for now
    @NotNull Long contactId
) {
}