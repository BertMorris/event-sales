package com.bertmorris.event_management.lead.dto;

import jakarta.validation.constraints.NotBlank;

public record LeadResponseDto(
    String id,
    String company,
    @NotBlank String title,
    String description,
    Integer budget,
    @NotBlank String ownerId,
    @NotBlank String contactId
) {
}