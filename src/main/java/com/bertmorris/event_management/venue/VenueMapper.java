package com.bertmorris.event_management.venue;

import org.mapstruct.Mapper;

import com.bertmorris.event_management.venue.dto.VenueResponseDto;

@Mapper(componentModel = "spring")
public interface VenueMapper {

    VenueResponseDto toResponseDto(Venue venue);

}