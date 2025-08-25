package com.bertmorris.event_management.lead.dto;

import java.time.LocalDate;

public record LeadUpdateRequestDto(
    String company,
    String title,
    String description,
    Integer budget,
    LocalDate date,
    Integer guests,
    Integer rooms,
    String ownerId, 
    String contactId
) {
}