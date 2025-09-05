package com.bertmorris.event_management.lead.dto;

import com.bertmorris.event_management.lead.LeadStatus;

import jakarta.validation.constraints.NotBlank;

public record LeadResponseDto(
    String id,
    LeadStatus status,
    String company,
    @NotBlank String title,
    String description,
    Integer budget,
    @NotBlank String ownerId,
    @NotBlank String contactId
) {
}