package com.bertmorris.event_management.user;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import jakarta.validation.constraints.NotNull;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User toRef(@NotNull Long id);

}