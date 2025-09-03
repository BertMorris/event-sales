package com.bertmorris.event_management.email.dto;

import java.time.Instant;
import java.util.List;

import com.bertmorris.event_management.email.recipient.dto.EmailRecipientResponseDto;

public record EmailResponseDto(
    String id,
    String providerId,
    String subject,
    String body,
    String conversationId,
    boolean hasAttachments,
    Instant readAt,
    Instant receivedAt,
    Instant sentAt,
    String senderId,
    List<EmailRecipientResponseDto> recipients
) {
}