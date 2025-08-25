package com.bertmorris.event_management.lead.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public record LeadResponseDto(
    String id,
    String company,
    @NotBlank String title,
    String description,
    Integer budget,
    LocalDate date,
    Integer guests,
    Integer rooms,
    @NotBlank String ownerId,
    @NotBlank String contactId
) {
}