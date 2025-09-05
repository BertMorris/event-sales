package com.bertmorris.event_management.event.function.setup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bertmorris.event_management.event.function.setup.dto.FunctionSetupResponseDto;
import com.bertmorris.event_management.event.function.setup.util.FunctionSetupTestBuilder;

@ExtendWith(SpringExtension.class)
@Import(FunctionSetupMapperImpl.class)
public class FunctionSetupMapperTest {
    
    @Autowired
    private FunctionSetupMapper functionSetupMapper;

    @Test
    void toResponseDto_shouldCreateFunctionSetupResponseDtoSuccessfully() {
        FunctionSetup functionSetup = FunctionSetupTestBuilder.aFunctionSetup().build();

        FunctionSetupResponseDto responseDto = functionSetupMapper.toResponseDto(functionSetup);

        assertNotNull(responseDto);
        assertEquals(functionSetup.getId().toString(), responseDto.id());
        assertEquals(functionSetup.getTitle(), responseDto.title());
    }
}
