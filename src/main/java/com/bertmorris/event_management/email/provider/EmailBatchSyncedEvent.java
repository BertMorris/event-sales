package com.bertmorris.event_management.email.provider;

import java.util.List;

import com.bertmorris.event_management.email.dto.EmailCreateDto;

public record EmailBatchSyncedEvent(
    List<EmailCreateDto> emailCreateDtos
) {
}