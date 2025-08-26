package com.bertmorris.event_management.lead.dto;

import com.bertmorris.event_management.lead.LeadStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// only title and contactId are truly required
// leaving optional fields for now
// user id is derived from jwt
public record LeadCreateRequestDto(
    @NotNull LeadStatus status,
    String company,
    @NotBlank String title,
    String description,
    Integer budget,
    @NotNull String contactId
) {
}