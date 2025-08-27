package com.bertmorris.event_management.user;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mapstruct.factory.Mappers;

@DisplayName("UserMapper Tests")
public class UserMapperTest {

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @ParameterizedTest
    @ValueSource(longs = { Long.MIN_VALUE, -1, 0, 1, Long.MAX_VALUE })
    @DisplayName("toRef should return User reference with correct ID")
    void toRef_shouldReturnUserRef(Long id) {
        User result = userMapper.toRef(id);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
        assertThat(result.getProviderId()).isNull();
        assertThat(result.getSyncKey()).isNull();
        assertThat(result.getCreatedAt()).isNull();
        assertThat(result.getUpdatedAt()).isNull();
    }
}
