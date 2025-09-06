package com.bertmorris.event_management.email.provider;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.bertmorris.event_management.contact.dto.ContactInfoDto;
import com.bertmorris.event_management.email.dto.EmailCreateDto;
import com.bertmorris.event_management.email.recipient.EmailRecipientType;
import com.bertmorris.event_management.email.recipient.dto.EmailRecipientCreateDto;
import com.microsoft.graph.models.Message;
import com.microsoft.graph.models.Recipient;

@Mapper(componentModel = "spring")
public interface EmailProviderMapper {

    @Mapping(target = "providerId", source = "id")
    @Mapping(target = "body", source = "body.content")
    @Mapping(target = "receivedAt", source = "receivedDateTime")
    @Mapping(target = "sentAt", source = "sentDateTime")
    @Mapping(target = "sender", source = "sender", qualifiedByName = "toContactInfoDto")
    @Mapping(target = "recipients", source = "message", qualifiedByName = "toEmailRecipientCreateDtos")
    EmailCreateDto toEmailCreateDto(Message message);

    List<EmailCreateDto> toEmailCreateDtos(List<Message> messages);

    @Named("toContactInfoDto")
    default ContactInfoDto toContactInfoDto(Recipient recipient) {
        return new ContactInfoDto(recipient.getEmailAddress().getName(), recipient.getEmailAddress().getAddress(), null);
    }

    @Named("toEmailRecipientCreateDtos")
    default List<EmailRecipientCreateDto> toEmailRecipientCreateDtos(Message message) {
        List<EmailRecipientCreateDto> emailRecipientCreateDtos = new ArrayList<>();
        
        for (Recipient recipient : message.getToRecipients()) {
            EmailRecipientCreateDto emailRecipientCreateDto = new EmailRecipientCreateDto(
                toContactInfoDto(recipient),
                EmailRecipientType.TO
            );
            emailRecipientCreateDtos.add(emailRecipientCreateDto);
        }

        for (Recipient recipient : message.getCcRecipients()) {
            EmailRecipientCreateDto emailRecipientCreateDto = new EmailRecipientCreateDto(
                toContactInfoDto(recipient),
                EmailRecipientType.CC
            );
            emailRecipientCreateDtos.add(emailRecipientCreateDto);
        }

        for (Recipient recipient : message.getBccRecipients()) {
            EmailRecipientCreateDto emailRecipientCreateDto = new EmailRecipientCreateDto(
                toContactInfoDto(recipient),
                EmailRecipientType.BCC
            );
            emailRecipientCreateDtos.add(emailRecipientCreateDto);
        }

        for (Recipient recipient : message.getReplyTo()) {
            EmailRecipientCreateDto emailRecipientCreateDto = new EmailRecipientCreateDto(
                toContactInfoDto(recipient),
                EmailRecipientType.REPLY_TO
            );
            emailRecipientCreateDtos.add(emailRecipientCreateDto);
        }

        return emailRecipientCreateDtos;
    }
    
}
