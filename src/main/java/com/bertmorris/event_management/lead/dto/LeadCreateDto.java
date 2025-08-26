package com.bertmorris.event_management.lead.dto;

import com.bertmorris.event_management.lead.LeadStatus;

import jakarta.validation.constraints.NotNull;

public record LeadCreateDto(
    @NotNull LeadStatus status,
    String company,
    String title,
    String description,
    Integer budget,
    @NotNull Long ownerId, // going with ids for now
    @NotNull Long contactId
) {
}