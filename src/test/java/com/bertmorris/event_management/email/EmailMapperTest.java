package com.bertmorris.event_management.email;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bertmorris.event_management.contact.Contact;
import com.bertmorris.event_management.contact.ContactMapperImpl;
import com.bertmorris.event_management.email.dto.EmailCreateDto;
import com.bertmorris.event_management.email.dto.EmailResponseDto;
import com.bertmorris.event_management.email.recipient.EmailRecipientMapperImpl;
import com.bertmorris.event_management.email.recipient.dto.EmailRecipientCreateDto;
import com.bertmorris.event_management.email.util.EmailCreateDtoTestBuilder;
import com.bertmorris.event_management.email.util.EmailTestBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

@ExtendWith(SpringExtension.class)
@Import({ EmailMapperImpl.class, EmailRecipientMapperImpl.class, ContactMapperImpl.class })
public class EmailMapperTest {
    
    @Autowired
    private EmailMapper emailMapper;

    @Test
    void toResponseDto_shouldCreateEmailResponseDtoSuccessfully() {
        Email email = EmailTestBuilder.anEmail().build();

        EmailResponseDto responseDto = emailMapper.toResponseDto(email);

        assertNotNull(responseDto);
        assertEquals(email.getId().toString(), responseDto.id());
        assertEquals(email.getProviderId(), responseDto.providerId());
        assertEquals(email.getSubject(), responseDto.subject());
        assertEquals(email.getBody(), responseDto.body());
        assertEquals(email.getConversationId(), responseDto.conversationId());
        assertEquals(email.hasAttachments(), responseDto.hasAttachments());
        assertEquals(email.getReadAt(), responseDto.readAt());
        assertEquals(email.getReceivedAt(), responseDto.receivedAt());
        assertEquals(email.getSentAt(), responseDto.sentAt());
        assertEquals(email.getSender().getId().toString(), responseDto.senderId());
        assertEquals(email.getRecipients().size(), responseDto.recipients().size());
    }

    @Test
    void toEntity_shouldCreateEmailSuccessfully() {
        EmailCreateDto dto = EmailCreateDtoTestBuilder.anEmailCreateDto().build();
        Map<String, Contact> contactMap = new HashMap<>();
        Contact sender = new Contact(dto.sender().name(), dto.sender().emailAddress());
        contactMap.put(dto.sender().emailAddress(), sender);
        for (EmailRecipientCreateDto recipientDto : dto.recipients()) {
            Contact recipient = new Contact(recipientDto.contactInfo().name(), recipientDto.contactInfo().emailAddress());
            contactMap.put(recipientDto.contactInfo().emailAddress(), recipient);
        }

        Email email = emailMapper.toEntity(dto, contactMap);

        assertNotNull(email);
        assertEquals(dto.providerId(), email.getProviderId());
        assertEquals(dto.subject(), email.getSubject());
        assertEquals(dto.body(), email.getBody());
        assertEquals(dto.conversationId(), email.getConversationId());
        assertEquals(dto.hasAttachments(), email.hasAttachments());
        assertEquals(dto.receivedAt(), email.getReceivedAt());
        assertEquals(dto.sentAt(), email.getSentAt());
        assertEquals(dto.sender().name(), email.getSender().getName());
        assertEquals(dto.sender().emailAddress(), email.getSender().getEmailAddress());
        assertEquals(dto.recipients().size(), email.getRecipients().size());
    }

}