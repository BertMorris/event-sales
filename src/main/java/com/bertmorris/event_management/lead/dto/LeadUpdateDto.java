package com.bertmorris.event_management.lead.dto;

import jakarta.validation.constraints.NotNull;

public record LeadUpdateDto(
    String company,
    String title,
    String description,
    Integer budget,
    @NotNull Long id,
    Long ownerId, // going with ids for now
    Long contactId
) {
}