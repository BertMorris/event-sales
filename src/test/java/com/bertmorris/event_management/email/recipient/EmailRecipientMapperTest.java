package com.bertmorris.event_management.email.recipient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bertmorris.event_management.contact.Contact;
import com.bertmorris.event_management.contact.ContactMapperImpl;
import com.bertmorris.event_management.contact.util.ContactTestBuilder;
import com.bertmorris.event_management.email.recipient.dto.EmailRecipientCreateDto;
import com.bertmorris.event_management.email.recipient.dto.EmailRecipientResponseDto;
import com.bertmorris.event_management.email.recipient.util.EmailRecipientCreateDtoTestBuilder;
import com.bertmorris.event_management.email.recipient.util.EmailRecipientTestBuilder;

@ExtendWith(SpringExtension.class)
@Import({ EmailRecipientMapperImpl.class, ContactMapperImpl.class })
public class EmailRecipientMapperTest {
    
    @Autowired
    private EmailRecipientMapper emailRecipientMapper;

    @Test
    void toResponseDto_shouldCreateEmailRecipientResponseDtoSuccessfully() {
        EmailRecipient recipient = EmailRecipientTestBuilder.anEmailRecipient().build();

        EmailRecipientResponseDto responseDto = emailRecipientMapper.toResponseDto(recipient);

        assertNotNull(responseDto);
        assertEquals(recipient.getContact().getId().toString(), responseDto.contactId());
        assertEquals(recipient.getType(), responseDto.type());
    }

   @Test
   void toEntity_shouldCreateEmailRecipientSuccessfully() {
    EmailRecipientCreateDto dto = EmailRecipientCreateDtoTestBuilder.anEmailRecipientCreateDto().build();

    Contact contact = ContactTestBuilder.aContact()
        .withName(dto.name())
        .withEmailAddress(dto.emailAddress())
        .build();

    Map<String, Contact> contactMap = Map.of(contact.getEmailAddress(), contact);

    EmailRecipient emailRecipient = emailRecipientMapper.toEntity(dto, contactMap);

    assertNotNull(emailRecipient);
    assertEquals(contact.getId(), emailRecipient.getContact().getId());
    assertEquals(dto.name(), emailRecipient.getContact().getName());
    assertEquals(dto.emailAddress(), emailRecipient.getContact().getEmailAddress());
    assertEquals(dto.type(), emailRecipient.getType());
    }
}