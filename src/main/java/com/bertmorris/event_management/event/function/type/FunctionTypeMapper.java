package com.bertmorris.event_management.event.function.type;

import org.mapstruct.Mapper;

import com.bertmorris.event_management.event.function.type.dto.FunctionTypeResponseDto;

@Mapper(componentModel = "spring")
public interface FunctionTypeMapper {

    FunctionTypeResponseDto toResponseDto(FunctionType functionType);

    FunctionType toRef(Long id);

}