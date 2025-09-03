package com.bertmorris.event_management.email;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bertmorris.event_management.email.dto.EmailCreateDto;
import com.bertmorris.event_management.email.dto.EmailResponseDto;
import com.bertmorris.event_management.email.recipient.EmailRecipientMapper;

@Mapper(componentModel = "spring", uses = { EmailRecipientMapper.class })
public interface EmailMapper {
 
    @Mapping(target = "senderId", source = "sender.id")
    EmailResponseDto toResponseDto(Email email);

    List<EmailResponseDto> toResponseDtos(List<Email> emails);

    Email toEntity(EmailCreateDto emailCreateDto);

}