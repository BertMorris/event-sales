package com.bertmorris.event_management.contact;

import java.util.Map;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.bertmorris.event_management.contact.dto.ContactResponseDto;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContactMapper {

    ContactResponseDto toResponseDto(Contact contact);

    // not sure if this is really needed
    default Contact toEntity(String emailAddress, @Context Map<String, Contact> contactMap) {
        Contact contact = contactMap.get(emailAddress);

        return contact;
    }
}