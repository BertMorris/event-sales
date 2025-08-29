package com.bertmorris.event_management.contact.dto;

import jakarta.validation.constraints.NotNull;

public record ContactUpdateDto(
    @NotNull Long id,
    String name,
    String emailAddress,
    String company
) {   
}