package com.bertmorris.event_management.lead;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bertmorris.event_management.contact.ContactMapperImpl;
import com.bertmorris.event_management.lead.dto.LeadCreateDto;
import com.bertmorris.event_management.lead.dto.LeadCreateRequestDto;
import com.bertmorris.event_management.lead.dto.LeadResponseDto;
import com.bertmorris.event_management.lead.dto.LeadUpdateDto;
import com.bertmorris.event_management.lead.dto.LeadUpdateRequestDto;
import com.bertmorris.event_management.lead.util.LeadCreateRequestDtoTestBuilder;
import com.bertmorris.event_management.lead.util.LeadTestBuilder;
import com.bertmorris.event_management.lead.util.LeadUpdateRequestDtoTestBuilder;
import com.bertmorris.event_management.user.UserMapperImpl;

@ExtendWith(SpringExtension.class)
@Import({
    LeadMapperImpl.class,
    UserMapperImpl.class,
    ContactMapperImpl.class
})
public class LeadMapperTest {

    @Autowired
    private LeadMapper leadMapper;

    @Test
    void toResponseDto_shouldCreateLeadResponseDtoSuccessfully() {
        Lead lead = LeadTestBuilder.aLead().build();

        LeadResponseDto responseDto = leadMapper.toResponseDto(lead);

        assertNotNull(responseDto);
        assertEquals(lead.getId().toString(), responseDto.id());
        assertEquals(lead.getStatus(), responseDto.status());
        assertEquals(lead.getCompany(), responseDto.company());
        assertEquals(lead.getTitle(), responseDto.title());
        assertEquals(lead.getDescription(), responseDto.description());
        assertEquals(lead.getBudget(), responseDto.budget());
        assertEquals(lead.getOwner().getId().toString(), responseDto.ownerId());
        assertEquals(lead.getContact().getId().toString(), responseDto.contactId());
    }

    @Test
    void toCreateDto_shouldCreateLeadCreateDtoSuccessfully() {
        Long ownerId = 1L;
        LeadCreateRequestDto requestDto = LeadCreateRequestDtoTestBuilder.aLeadCreateRequestDto().build();

        LeadCreateDto leadCreateDto = leadMapper.toCreateDto(ownerId, requestDto);

        assertNotNull(leadCreateDto);
        assertEquals(ownerId, leadCreateDto.ownerId());
        assertEquals(requestDto.status(), leadCreateDto.status());
        assertEquals(requestDto.company(), leadCreateDto.company());
        assertEquals(requestDto.title(), leadCreateDto.title());
        assertEquals(requestDto.description(), leadCreateDto.description());
        assertEquals(requestDto.budget(), leadCreateDto.budget());
        assertEquals(Long.valueOf(requestDto.contactId()), leadCreateDto.contactId());
    }

    @Test
    void toUpdateDto_shouldCreateLeadUpdateDtoSuccessfully() {
        Long id = 1L;
        LeadUpdateRequestDto requestDto = LeadUpdateRequestDtoTestBuilder.aLeadUpdateRequestDto().build();

        LeadUpdateDto leadUpdateDto = leadMapper.toUpdateDto(id, requestDto);

        assertNotNull(leadUpdateDto);
        assertEquals(id, leadUpdateDto.id());
        assertEquals(Long.valueOf(requestDto.ownerId()), leadUpdateDto.ownerId());
        assertEquals(Long.valueOf(requestDto.contactId()), leadUpdateDto.contactId());
        assertEquals(requestDto.status(), leadUpdateDto.status());
        assertEquals(requestDto.company(), leadUpdateDto.company());
        assertEquals(requestDto.title(), leadUpdateDto.title());
        assertEquals(requestDto.description(), leadUpdateDto.description());
        assertEquals(requestDto.budget(), leadUpdateDto.budget());
    }
}
