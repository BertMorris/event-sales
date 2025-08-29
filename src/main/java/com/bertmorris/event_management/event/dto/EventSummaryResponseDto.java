package com.bertmorris.event_management.event.dto;

import java.time.LocalDate;

import com.bertmorris.event_management.event.EventStatus;

public record EventSummaryResponseDto(
    String id,
    String leadId,
    EventStatus status,
    String typeId,
    String title,
    String company,
    String contactId,
    LocalDate startDate,
    LocalDate endDate,
    String venueId,
    Integer guests,
    Integer rooms
) {
}