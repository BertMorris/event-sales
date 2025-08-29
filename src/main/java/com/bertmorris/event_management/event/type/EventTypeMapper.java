package com.bertmorris.event_management.event.type;

import org.mapstruct.Mapper;

import com.bertmorris.event_management.event.type.dto.EventTypeResponseDto;

@Mapper(componentModel = "spring")
public interface EventTypeMapper {

    EventTypeResponseDto toResponseDto(EventType eventType);

    EventType toRef(Long id);

}