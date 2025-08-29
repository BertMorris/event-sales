package com.bertmorris.event_management.venue.dto;

public record VenueResponseDto(
    String id,
    String name,
    Integer capacity
) {
}