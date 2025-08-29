package com.bertmorris.event_management.contact.dto;

import jakarta.validation.constraints.NotNull;

public record ContactResponseDto(
    @NotNull String id,
    String name,
    String emailAddress,
    String company
) {
}