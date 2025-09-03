package com.bertmorris.event_management.email.dto;

import java.time.OffsetDateTime;
import java.util.List;

import com.bertmorris.event_management.email.recipient.dto.EmailRecipientResponseDto;

public record EmailResponseDto(
    String id,
    String providerId,
    String subject,
    String body,
    String conversationId,
    boolean hasAttachments,
    OffsetDateTime readAt,
    OffsetDateTime receivedAt,
    OffsetDateTime sentAt,
    String senderId,
    List<EmailRecipientResponseDto> recipients
) {
}