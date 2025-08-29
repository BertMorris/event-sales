package com.bertmorris.event_management.contact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.bertmorris.event_management.contact.dto.ContactResponseDto;

@DisplayName("ContactMapper Tests")
class ContactMapperTest {

    private final ContactMapper contactMapper = Mappers.getMapper(ContactMapper.class);

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
