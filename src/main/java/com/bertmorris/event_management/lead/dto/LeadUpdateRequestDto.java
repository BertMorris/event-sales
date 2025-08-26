package com.bertmorris.event_management.lead.dto;

import com.bertmorris.event_management.lead.LeadStatus;

public record LeadUpdateRequestDto(
    LeadStatus status,
    String company,
    String title,
    String description,
    Integer budget,
    String ownerId, 
    String contactId
) {
}