package com.bertmorris.event_management.lead;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.bertmorris.event_management.contact.ContactMapper;
import com.bertmorris.event_management.lead.dto.LeadCreateDto;
import com.bertmorris.event_management.user.UserMapper;

@DisplayName("LeadMapper Tests")
public class LeadMapperTests {

    private LeadMapper leadMapper;

    @BeforeEach
    void setUp() {
        UserMapper userMapper = Mappers.getMapper(UserMapper.class);
        ContactMapper contactMapper = Mappers.getMapper(ContactMapper.class);

        leadMapper = new LeadMapperImpl(userMapper, contactMapper);
    }

    @Test
    void toEntity_shouldCreateLeadWithMinimalValues() {
        LeadCreateDto dto = LeadCreateDto.builder()
            .status(LeadStatus.NEW)
            .ownerId(1L)
            .contactId(2L)
            .build();

        Lead result = leadMapper.toEntity(dto);

        assertThat(result).isNotNull();
        assertThat(result.getOwner().getId()).isEqualTo(1L);
        assertThat(result.getContact().getId()).isEqualTo(2L);
        assertThat(result.getStatus()).isEqualTo(LeadStatus.NEW);
        assertThat(result.getId()).isNull();
        assertThat(result.getCompany()).isNull();
        assertThat(result.getTitle()).isNull();
        assertThat(result.getDescription()).isNull();
        assertThat(result.getBudget()).isNull();
        assertThat(result.getCreatedAt()).isNull();
        assertThat(result.getUpdatedAt()).isNull();
    }
}
