package com.bertmorris.event_management.email.recipient.dto;

import com.bertmorris.event_management.email.recipient.EmailRecipientType;

public record EmailRecipientCreateDto(
    String name,
    String emailAddress,
    EmailRecipientType type
) {
}