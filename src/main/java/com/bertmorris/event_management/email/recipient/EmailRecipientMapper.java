package com.bertmorris.event_management.email.recipient;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bertmorris.event_management.email.recipient.dto.EmailRecipientResponseDto;

@Mapper(componentModel = "spring")
public interface EmailRecipientMapper {
    
    @Mapping(target = "contactId", source = "contact.id")
    EmailRecipientResponseDto toReponseDto(EmailRecipient recipient);

}