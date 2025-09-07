package com.bertmorris.event_management.email.util;

import java.time.OffsetDateTime;
import java.util.List;

import com.bertmorris.event_management.contact.dto.ContactInfoDto;
import com.bertmorris.event_management.email.dto.EmailCreateDto;
import com.bertmorris.event_management.email.recipient.dto.EmailRecipientCreateDto;
import com.bertmorris.event_management.email.recipient.util.EmailRecipientCreateDtoTestBuilder;

public class EmailCreateDtoTestBuilder {
    
    private String providerId;
    private ContactInfoDto sender;
    private String subject;
    private String body;
    private String conversationId;
    private boolean hasAttachments;
    private OffsetDateTime receivedAt;
    private OffsetDateTime sentAt;
    private List<EmailRecipientCreateDto> recipients;

    public static EmailCreateDtoTestBuilder anEmailCreateDto() {
        return new EmailCreateDtoTestBuilder()
            .withProviderId("providerId")
            .withSender(new ContactInfoDto("senderName", "senderEmail"))
            .withSubject("subject")
            .withBody("body")
            .withConversationId("conversationId")
            .withHasAttachments(false)
            .withReceivedAt(OffsetDateTime.now())
            .withSentAt(OffsetDateTime.now())
            .withRecipients(List.of(EmailRecipientCreateDtoTestBuilder.anEmailRecipientCreateDto().build()));
    }

    public EmailCreateDto build() {
        return new EmailCreateDto(
            this.providerId,
            this.sender,
            this.subject,
            this.body,
            this.conversationId,
            this.hasAttachments,
            this.receivedAt,
            this.sentAt,
            this.recipients);
    }

    public EmailCreateDtoTestBuilder withProviderId(String providerId) {
        this.providerId = providerId;
        return this;
    }

    public EmailCreateDtoTestBuilder withSender(ContactInfoDto sender) {
        this.sender = sender;
        return this;
    }

    public EmailCreateDtoTestBuilder withSubject(String subject) {
        this.subject = subject;
        return this;
    }
    
    public EmailCreateDtoTestBuilder withBody(String body) {
        this.body = body;
        return this;
    }

    public EmailCreateDtoTestBuilder withConversationId(String conversationId) {
        this.conversationId = conversationId;
        return this;
    }
    
    public EmailCreateDtoTestBuilder withHasAttachments(boolean hasAttachments) {
        this.hasAttachments = hasAttachments;
        return this;
    }

    public EmailCreateDtoTestBuilder withReceivedAt(OffsetDateTime receivedAt) {
        this.receivedAt = receivedAt;
        return this;
    }

    public EmailCreateDtoTestBuilder withSentAt(OffsetDateTime sentAt) {
        this.sentAt = sentAt;
        return this;
    }

    public EmailCreateDtoTestBuilder withRecipients(List<EmailRecipientCreateDto> recipients) {
        this.recipients = recipients;
        return this;
    }

}
