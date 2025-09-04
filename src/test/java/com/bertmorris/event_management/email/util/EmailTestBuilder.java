package com.bertmorris.event_management.email.util;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.test.util.ReflectionTestUtils;

import com.bertmorris.event_management.contact.Contact;
import com.bertmorris.event_management.contact.util.ContactTestBuilder;
import com.bertmorris.event_management.email.Email;
import com.bertmorris.event_management.email.recipient.EmailRecipient;
import com.bertmorris.event_management.email.recipient.EmailRecipientType;

public class EmailTestBuilder {
   
    private Long id;
    private String providerId;
    private String subject;
    private String body;
    private String conversationId;
    private boolean hasAttachments;
    private OffsetDateTime readAt;
    private OffsetDateTime receivedAt;
    private OffsetDateTime sentAt;
    private Contact sender;
    private List<EmailRecipient> recipients;

    public static EmailTestBuilder anEmail() {
        return new EmailTestBuilder()
            .withId(1L)
            .withProviderId("providerId")
            .withSubject("subject")
            .withBody("body")
            .withConversationId("conversationId")
            .withHasAttachments(false)
            .withReadAt(OffsetDateTime.now())
            .withReceivedAt(OffsetDateTime.now())
            .withSentAt(OffsetDateTime.now())
            .withSender(ContactTestBuilder.aContact().build());
    }

    public Email build() {
        Email email = new Email();
        ReflectionTestUtils.setField(email, "id", this.id);
        email.setProviderId(this.providerId);
        email.setSubject(this.subject);
        email.setBody(this.body);
        email.setConversationId(this.conversationId);
        email.setHasAttachments(this.hasAttachments);
        email.setReadAt(this.readAt);
        email.setReceivedAt(this.receivedAt);
        email.setSentAt(this.sentAt);
        email.setSender(this.sender);
        if (this.recipients != null) {
            for (EmailRecipient recipient : this.recipients) {
                recipient.setEmail(email);
            }

            email.setRecipients(this.recipients);
        } else {
            EmailRecipient recipient = new EmailRecipient();
            ReflectionTestUtils.setField(recipient, "id", 1L);
            recipient.setType(EmailRecipientType.TO);
            recipient.setEmail(email);
            recipient.setContact(ContactTestBuilder.aContact().build());

            email.setRecipients(List.of(recipient));
        }
       
        return email;
    }

    public EmailTestBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public EmailTestBuilder withProviderId(String providerId) {
        this.providerId = providerId;
        return this;
    }

    public EmailTestBuilder withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public EmailTestBuilder withBody(String body) {
        this.body = body;
        return this;
    }

    public EmailTestBuilder withConversationId(String conversationId) {
        this.conversationId = conversationId;
        return this;
    }

    public EmailTestBuilder withHasAttachments(boolean hasAttachments) {
        this.hasAttachments = hasAttachments;
        return this;
    }

    public EmailTestBuilder withReadAt(OffsetDateTime readAt) {
        this.readAt = readAt;
        return this;
    }

    public EmailTestBuilder withReceivedAt(OffsetDateTime receivedAt) {
        this.receivedAt = receivedAt;
        return this;
    }

    public EmailTestBuilder withSentAt(OffsetDateTime sentAt) {
        this.sentAt = sentAt;
        return this;
    }

    public EmailTestBuilder withSender(Contact sender) {
        this.sender = sender;
        return this;
    }

    public EmailTestBuilder withRecipients(List<EmailRecipient> recipients) {
        this.recipients = recipients;
        return this;
    }

}