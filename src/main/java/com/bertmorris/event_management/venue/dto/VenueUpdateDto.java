package com.bertmorris.event_management.venue.dto;

import jakarta.validation.constraints.NotNull;

public record VenueUpdateDto(
    @NotNull Long id,
    String name,
    Integer capacity
) { 
}