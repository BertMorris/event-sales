package com.bertmorris.event_management.contact;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.bertmorris.event_management.contact.dto.ContactResponseDto;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContactMapper {

    ContactResponseDto toResponseDto(Contact contact);

}