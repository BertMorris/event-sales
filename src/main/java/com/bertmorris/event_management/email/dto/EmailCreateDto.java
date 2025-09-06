package com.bertmorris.event_management.email.dto;

import java.time.OffsetDateTime;
import java.util.List;

import com.bertmorris.event_management.contact.dto.ContactInfoDto;
import com.bertmorris.event_management.email.recipient.dto.EmailRecipientCreateDto;

public record EmailCreateDto(
    String providerId,
    ContactInfoDto sender,
    String subject,
    String body,
    String conversationId,
    boolean hasAttachments,
    OffsetDateTime receivedAt,
    OffsetDateTime sentAt,
    List<EmailRecipientCreateDto> recipients
) {
}