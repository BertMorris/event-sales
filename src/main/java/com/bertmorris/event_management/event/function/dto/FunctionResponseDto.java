package com.bertmorris.event_management.event.function.dto;

import java.time.OffsetDateTime;

import com.bertmorris.event_management.event.function.setup.dto.FunctionSetupResponseDto;
import com.bertmorris.event_management.event.function.type.dto.FunctionTypeResponseDto;
import com.bertmorris.event_management.venue.dto.VenueResponseDto;

public record FunctionResponseDto(
    Long id, 
    OffsetDateTime startTime,
    OffsetDateTime endTime,
    Integer guests,
    FunctionTypeResponseDto type,
    VenueResponseDto venue,
    FunctionSetupResponseDto setup
) { 
}
