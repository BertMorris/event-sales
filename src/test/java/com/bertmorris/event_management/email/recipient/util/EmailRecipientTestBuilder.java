package com.bertmorris.event_management.email.recipient.util;

import org.springframework.test.util.ReflectionTestUtils;

import com.bertmorris.event_management.contact.Contact;
import com.bertmorris.event_management.contact.util.ContactTestBuilder;
import com.bertmorris.event_management.email.Email;
import com.bertmorris.event_management.email.recipient.EmailRecipient;
import com.bertmorris.event_management.email.recipient.EmailRecipientType;
import com.bertmorris.event_management.email.util.EmailTestBuilder;

public class EmailRecipientTestBuilder {
   
    private Long id;
    private EmailRecipientType type;
    private Email email;
    private Contact contact;

    public static EmailRecipientTestBuilder anEmailRecipient() {
        return new EmailRecipientTestBuilder()
            .withId(1L)
            .withType(EmailRecipientType.TO)
            .withEmail(EmailTestBuilder.anEmail().build())
            .withContact(ContactTestBuilder.aContact().build());
    }

    public EmailRecipient build() {
        EmailRecipient emailRecipient = new EmailRecipient();
        ReflectionTestUtils.setField(emailRecipient, "id", this.id);
        emailRecipient.setType(this.type);
        emailRecipient.setEmail(this.email);
        emailRecipient.setContact(this.contact);
    
        return emailRecipient;
    }

    public EmailRecipientTestBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public EmailRecipientTestBuilder withType(EmailRecipientType type) {
        this.type = type;
        return this;
    }

    public EmailRecipientTestBuilder withEmail(Email email) {
        this.email = email;
        return this;
    }

    public EmailRecipientTestBuilder withContact(Contact contact) {
        this.contact = contact;
        return this;
    }
}