package com.bertmorris.event_management.email.recipient.util;

import com.bertmorris.event_management.email.recipient.EmailRecipientType;
import com.bertmorris.event_management.email.recipient.dto.EmailRecipientCreateDto;

public class EmailRecipientCreateDtoTestBuilder {
   
    String name;
    String emailAddress;
    EmailRecipientType type;

    public static EmailRecipientCreateDtoTestBuilder anEmailRecipientCreateDto() {
        return new EmailRecipientCreateDtoTestBuilder()
            .withName("name")
            .withEmailAddress("recipient@email.com")
            .withType(EmailRecipientType.TO);
    }

    public EmailRecipientCreateDto build() {
        return new EmailRecipientCreateDto(this.name, this.emailAddress, this.type);
    }

    public EmailRecipientCreateDtoTestBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public EmailRecipientCreateDtoTestBuilder withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public EmailRecipientCreateDtoTestBuilder withType(EmailRecipientType type) {
        this.type = type;
        return this;
    }
}
