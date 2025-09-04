package com.bertmorris.event_management.email.recipient;

import java.util.Map;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bertmorris.event_management.contact.Contact;
import com.bertmorris.event_management.contact.ContactMapper;
import com.bertmorris.event_management.email.recipient.dto.EmailRecipientCreateDto;
import com.bertmorris.event_management.email.recipient.dto.EmailRecipientResponseDto;

@Mapper(componentModel = "spring", uses = { ContactMapper.class })
public interface EmailRecipientMapper {
    
    @Mapping(target = "contactId", source = "contact.id")
    EmailRecipientResponseDto toResponseDto(EmailRecipient recipient);

    @Mapping(target = "contact", source = "emailAddress")
    EmailRecipient toEntity(EmailRecipientCreateDto emailRecipientCreateDto, @Context Map<String, Contact> contactMap);

}