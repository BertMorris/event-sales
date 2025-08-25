package com.bertmorris.event_management.venue.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VenueCreateDto(
    @NotBlank String name,
    @NotNull Integer capacity
) {
    
}
