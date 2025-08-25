package com.bertmorris.event_management.lead.dto;

public record LeadUpdateRequestDto(
    String company,
    String title,
    String description,
    Integer budget,
    String ownerId, 
    String contactId
) {
}