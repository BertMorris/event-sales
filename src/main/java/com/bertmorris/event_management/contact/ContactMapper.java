package com.bertmorris.event_management.contact;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import jakarta.validation.constraints.NotNull;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContactMapper {

    Contact toRef(@NotNull Long id);

}
