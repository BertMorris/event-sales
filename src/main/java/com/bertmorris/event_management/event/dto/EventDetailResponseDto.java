package com.bertmorris.event_management.event.dto;

import java.time.LocalDate;
import java.util.List;

import com.bertmorris.event_management.event.EventStatus;
import com.bertmorris.event_management.event.function.dto.FunctionResponseDto;

public record EventDetailResponseDto(
    String id,
    EventStatus status,
    String title,
    String company,
    LocalDate startDate,
    LocalDate endDate,
    Integer guests,
    Integer rooms,
    String ownerId,
    String leadId,
    String contactId,
    String typeId,
    String venueId,
    List<FunctionResponseDto> functions
    ) {  
}