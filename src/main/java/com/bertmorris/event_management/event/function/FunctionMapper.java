package com.bertmorris.event_management.event.function;

import org.mapstruct.Mapper;

import com.bertmorris.event_management.event.function.dto.FunctionResponseDto;
import com.bertmorris.event_management.event.function.setup.FunctionSetupMapper;
import com.bertmorris.event_management.event.function.type.FunctionTypeMapper;
import com.bertmorris.event_management.venue.VenueMapper;

@Mapper(componentModel = "spring", uses = { FunctionTypeMapper.class, VenueMapper.class, FunctionSetupMapper.class })
public interface FunctionMapper {
    
    FunctionResponseDto toResponseDto(Function function);

}