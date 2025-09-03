package com.bertmorris.event_management.email.dto;

import java.time.Instant;
import java.util.List;

import com.bertmorris.event_management.email.recipient.dto.EmailRecipientCreateDto;

public record EmailCreateDto(
    String providerId,
    String senderName,
    String senderEmail,
    String subject,
    String body,
    String conversationId,
    boolean hasAttachments,
    Instant receivedAt,
    Instant sentAt,
    List<EmailRecipientCreateDto> recipients
) {
    
}
