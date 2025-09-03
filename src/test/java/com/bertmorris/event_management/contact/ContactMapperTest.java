package com.bertmorris.event_management.contact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bertmorris.event_management.contact.dto.ContactResponseDto;

@ExtendWith(SpringExtension.class)
@Import(ContactMapperImpl.class)
class ContactMapperTest {

    @Autowired
    private ContactMapper contactMapper;

    @Test
    void toResponseDto_shouldCreateContactResponseDtoSuccessfully() {
        Contact contact = new Contact();
        contact.setId(1L);
        contact.setName("name");
        contact.setEmailAddress("test@email.com");
        contact.setCompany("company");

        ContactResponseDto responseDto = contactMapper.toResponseDto(contact);

        assertNotNull(responseDto);
        assertEquals(contact.getId().toString(), responseDto.id());
        assertEquals(contact.getName(), responseDto.name());
        assertEquals(contact.getEmailAddress(), responseDto.emailAddress());
        assertEquals(contact.getCompany(), responseDto.company());
    }
}