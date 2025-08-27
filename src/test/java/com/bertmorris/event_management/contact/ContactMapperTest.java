package com.bertmorris.event_management.contact;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mapstruct.factory.Mappers;

@DisplayName("ContactMapper Tests")
class ContactMapperTest {

    private final ContactMapper contactMapper = Mappers.getMapper(ContactMapper.class);

    @ParameterizedTest
    @ValueSource(longs = { Long.MIN_VALUE, -1, 0, 1, Long.MAX_VALUE })
    @DisplayName("toRef should return Contact reference with correct ID")
    void toRef_shouldReturnContactRef(Long id) {
        Contact result = contactMapper.toRef(id);
        
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
        assertThat(result.getName()).isNull();
        assertThat(result.getEmailAddress()).isNull();
        assertThat(result.getCompany()).isNull();
        assertThat(result.getCreatedAt()).isNull();
        assertThat(result.getUpdatedAt()).isNull();
    }
    
}
