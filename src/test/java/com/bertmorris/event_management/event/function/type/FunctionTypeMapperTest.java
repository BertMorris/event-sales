package com.bertmorris.event_management.event.function.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bertmorris.event_management.event.function.type.dto.FunctionTypeResponseDto;
import com.bertmorris.event_management.event.function.type.util.FunctionTypeTestBuilder;

@ExtendWith(SpringExtension.class)
@Import(FunctionTypeMapperImpl.class)
public class FunctionTypeMapperTest {
    
    @Autowired
    private FunctionTypeMapper functionTypeMapper;

    @Test
    void toResponseDto_shouldCreateFunctionTypeResponseDtoSuccessfully() {
        FunctionType functionType = FunctionTypeTestBuilder.aFunctionType().build();

        FunctionTypeResponseDto responseDto = functionTypeMapper.toResponseDto(functionType);

        assertNotNull(responseDto);
        assertEquals(functionType.getId().toString(), responseDto.id());
        assertEquals(functionType.getTitle(), responseDto.title());
    }
}
