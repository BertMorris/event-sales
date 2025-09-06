package com.bertmorris.event_management.email;

import java.util.List;
import java.util.Map;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bertmorris.event_management.contact.Contact;
import com.bertmorris.event_management.contact.ContactMapper;
import com.bertmorris.event_management.email.dto.EmailCreateDto;
import com.bertmorris.event_management.email.dto.EmailResponseDto;
import com.bertmorris.event_management.email.recipient.EmailRecipientMapper;

@Mapper(componentModel = "spring", uses = { ContactMapper.class, EmailRecipientMapper.class })
public interface EmailMapper {
 
    @Mapping(target = "senderId", source = "sender.id")
    EmailResponseDto toResponseDto(Email email);

    List<EmailResponseDto> toResponseDtos(List<Email> emails);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "sender", source = "senderEmail", qualifiedByName = "mapEmailAddressToContact")
    Email toEntity(EmailCreateDto emailCreateDto, @Context Map<String, Contact> contactMap);

    List<Email> toEntities(List<EmailCreateDto> emailCreateDtos, @Context Map<String, Contact> contactMap);

}