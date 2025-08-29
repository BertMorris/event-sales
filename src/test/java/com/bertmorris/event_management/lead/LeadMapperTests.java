package com.bertmorris.event_management.lead;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bertmorris.event_management.contact.ContactMapperImpl;
import com.bertmorris.event_management.lead.dto.LeadCreateDto;
import com.bertmorris.event_management.user.UserMapperImpl;

@ExtendWith(SpringExtension.class)
@Import({LeadMapperImpl.class,
    UserMapperImpl.class,
    ContactMapperImpl.class
})
public class LeadMapperTests {

    @Autowired
    private LeadMapper leadMapper;

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
