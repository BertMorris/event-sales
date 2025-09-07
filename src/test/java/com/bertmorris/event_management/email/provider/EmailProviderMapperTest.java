package com.bertmorris.event_management.email.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bertmorris.event_management.email.dto.EmailCreateDto;
import com.bertmorris.event_management.email.provider.util.GraphMessageTestBuilder;
import com.bertmorris.event_management.email.recipient.EmailRecipientType;
import com.bertmorris.event_management.email.recipient.dto.EmailRecipientCreateDto;
import com.microsoft.graph.models.Message;

@ExtendWith(SpringExtension.class)
@Import(EmailProviderMapperImpl.class)
public class EmailProviderMapperTest {
   
    @Autowired
    private EmailProviderMapper emailProviderMapper;

    @Test
    void toEmailCreateDto_shouldCreateEmailCreateDtoSuccessfully() {
        Message message = GraphMessageTestBuilder.aMessage().build();

        EmailCreateDto emailCreateDto = emailProviderMapper.toEmailCreateDto(message);

        assertNotNull(emailCreateDto);
        assertEquals(message.getId(), emailCreateDto.providerId());
        assertEquals(message.getSender().getEmailAddress().getName(), emailCreateDto.sender().name());
        assertEquals(message.getSender().getEmailAddress().getAddress(), emailCreateDto.sender().emailAddress());
        assertEquals(message.getSubject(), emailCreateDto.subject());
        assertEquals(message.getBody().getContent(), emailCreateDto.body());
        assertEquals(message.getConversationId(), emailCreateDto.conversationId());
        assertEquals(message.getHasAttachments(), emailCreateDto.hasAttachments());
        assertEquals(message.getReceivedDateTime(), emailCreateDto.receivedAt());
        assertEquals(message.getSentDateTime(), emailCreateDto.sentAt());
        assertEquals(
            message.getToRecipients().size() + message.getCcRecipients().size() + message.getBccRecipients().size() + message.getReplyTo().size(),
            emailCreateDto.recipients().size());
    }

    @Test
    void toEmailRecipientCreateDtos_shouldCreateEmailRecipientCreateDtosSuccessfully() {
        Message message = GraphMessageTestBuilder.aMessage().build();

        List<EmailRecipientCreateDto> dtos = emailProviderMapper.toEmailRecipientCreateDtos(message);

        assertNotNull(dtos);
        assertEquals(
            message.getToRecipients().size(),
            countRecipientsByType(dtos, EmailRecipientType.TO)
        );
        assertEquals(
            message.getCcRecipients().size(),
            countRecipientsByType(dtos, EmailRecipientType.CC)
        );
        assertEquals(
            message.getBccRecipients().size(),
            countRecipientsByType(dtos, EmailRecipientType.BCC)
        );
        assertEquals(
            message.getReplyTo().size(),
            countRecipientsByType(dtos, EmailRecipientType.REPLY_TO)
        );
        assertEquals(
            message.getToRecipients().get(0).getEmailAddress().getName(),
            getFirstRecipientName(dtos, EmailRecipientType.TO)
        );
        assertEquals(
            message.getCcRecipients().get(0).getEmailAddress().getName(),
            getFirstRecipientName(dtos, EmailRecipientType.CC)
        );
        assertEquals(
            message.getBccRecipients().get(0).getEmailAddress().getName(),
            getFirstRecipientName(dtos, EmailRecipientType.BCC)
        );
        assertEquals(
            message.getReplyTo().get(0).getEmailAddress().getName(),
            getFirstRecipientName(dtos, EmailRecipientType.REPLY_TO)
        );
    }

    private long countRecipientsByType(List<EmailRecipientCreateDto> dtos, EmailRecipientType type) {
        return dtos.stream().filter(dto -> dto.type() == type).count();
    }

    private String getFirstRecipientName(List<EmailRecipientCreateDto> dtos, EmailRecipientType type) {
        return dtos.stream().filter(dto -> dto.type() == type).findFirst().get().contactInfo().name();
    }
}