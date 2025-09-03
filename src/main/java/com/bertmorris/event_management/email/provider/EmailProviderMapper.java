package com.bertmorris.event_management.email.provider;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bertmorris.event_management.email.dto.EmailCreateDto;
import com.bertmorris.event_management.email.recipient.EmailRecipientType;
import com.bertmorris.event_management.email.recipient.dto.EmailRecipientCreateDto;
import com.microsoft.graph.models.Message;
import com.microsoft.graph.models.Recipient;

@Mapper(componentModel = "spring")
public interface EmailProviderMapper {

    @Mapping(target = "recipients", expression = "java(toEmailRecipientCreateDtos(message))")
    EmailCreateDto toEmailCreateDto(Message message);

    List<EmailCreateDto> toEmailCreateDtos(List<Message> messages);

    default List<EmailRecipientCreateDto> toEmailRecipientCreateDtos(Message message) {
        List<EmailRecipientCreateDto> emailRecipientCreateDtos = new ArrayList<>();
        
        for (Recipient recipient : message.getToRecipients()) {
            EmailRecipientCreateDto emailRecipientCreateDto = new EmailRecipientCreateDto(
                recipient.getEmailAddress().getName(),
                recipient.getEmailAddress().getAddress(),
                EmailRecipientType.TO
            );
            emailRecipientCreateDtos.add(emailRecipientCreateDto);
        }

        for (Recipient recipient : message.getCcRecipients()) {
            EmailRecipientCreateDto emailRecipientCreateDto = new EmailRecipientCreateDto(
                recipient.getEmailAddress().getName(),
                recipient.getEmailAddress().getAddress(),
                EmailRecipientType.CC
            );
            emailRecipientCreateDtos.add(emailRecipientCreateDto);
        }

        for (Recipient recipient : message.getBccRecipients()) {
            EmailRecipientCreateDto emailRecipientCreateDto = new EmailRecipientCreateDto(
                recipient.getEmailAddress().getName(),
                recipient.getEmailAddress().getAddress(),
                EmailRecipientType.BCC
            );
            emailRecipientCreateDtos.add(emailRecipientCreateDto);
        }

        for (Recipient recipient : message.getReplyTo()) {
            EmailRecipientCreateDto emailRecipientCreateDto = new EmailRecipientCreateDto(
                recipient.getEmailAddress().getName(),
                recipient.getEmailAddress().getAddress(),
                EmailRecipientType.REPLY_TO
            );
            emailRecipientCreateDtos.add(emailRecipientCreateDto);
        }

        return emailRecipientCreateDtos;
    }
    
}
