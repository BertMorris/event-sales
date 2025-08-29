package com.bertmorris.event_management.user;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mapstruct.factory.Mappers;

@DisplayName("UserMapper Tests")
public class UserMapperTest {

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

}
