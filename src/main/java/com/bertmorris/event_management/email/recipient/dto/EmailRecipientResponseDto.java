package com.bertmorris.event_management.email.recipient.dto;

import com.bertmorris.event_management.email.recipient.EmailRecipientType;

public record EmailRecipientResponseDto(
    String contactId,
    EmailRecipientType type
) {
}