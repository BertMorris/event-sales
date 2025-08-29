package com.bertmorris.event_management.event.function.setup;

import org.mapstruct.Mapper;

import com.bertmorris.event_management.event.function.setup.dto.FunctionSetupResponseDto;

@Mapper(componentModel = "spring")
public interface FunctionSetupMapper {

    FunctionSetupResponseDto toResponseDto(FunctionSetup functionSetup);

}
