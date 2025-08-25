package com.bertmorris.event_management.lead.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// only title and contactId are truly required
// leaving optional fields for now
// user id is derived from jwt
public record LeadCreateRequestDto(
    String company,
    @NotBlank String title,
    String description,
    Integer budget,
    LocalDate date,
    Integer guests,
    Integer rooms,
    @NotNull Long contactId
) {
}
