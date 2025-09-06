package com.bertmorris.event_management.contact.dto;

import jakarta.validation.constraints.NotNull;

public record ContactInfoDto(
    @NotNull String name,
    @NotNull String emailAddress,
    String company
) {
}