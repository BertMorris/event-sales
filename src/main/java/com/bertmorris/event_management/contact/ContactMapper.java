package com.bertmorris.event_management.contact;

import java.util.Map;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import com.bertmorris.event_management.contact.dto.ContactInfoDto;
import com.bertmorris.event_management.contact.dto.ContactResponseDto;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContactMapper {

    ContactResponseDto toResponseDto(Contact contact);

    @Named("mapContactInfoDtoToContact")
    default Contact toEntity(ContactInfoDto contactInfo, @Context Map<String, Contact> contactMap) {
        Contact contact = contactMap.get(contactInfo.emailAddress());

        return contact;
    }

    // not sure if this is really needed
    @Named("mapEmailAddressToContact")
    default Contact toEntity(String emailAddress, @Context Map<String, Contact> contactMap) {
        Contact contact = contactMap.get(emailAddress);

        return contact;
    }
}