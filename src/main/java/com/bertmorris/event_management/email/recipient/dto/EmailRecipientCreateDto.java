package com.bertmorris.event_management.email.recipient.dto;

import com.bertmorris.event_management.contact.dto.ContactInfoDto;
import com.bertmorris.event_management.email.recipient.EmailRecipientType;

public record EmailRecipientCreateDto(
    ContactInfoDto contactInfo,
    EmailRecipientType type
) {
}