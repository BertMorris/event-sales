package com.bertmorris.event_management.event.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bertmorris.event_management.event.Event;
import com.bertmorris.event_management.event.function.dto.FunctionResponseDto;
import com.bertmorris.event_management.event.function.setup.FunctionSetupMapperImpl;
import com.bertmorris.event_management.event.function.type.FunctionTypeMapperImpl;
import com.bertmorris.event_management.event.function.util.FunctionTestBuilder;
import com.bertmorris.event_management.event.util.EventTestBuilder;
import com.bertmorris.event_management.venue.VenueMapperImpl;

@ExtendWith(SpringExtension.class)
@Import({
    FunctionMapperImpl.class,
    FunctionTypeMapperImpl.class,
    VenueMapperImpl.class,
    FunctionSetupMapperImpl.class
})
public class FunctionMapperTest {
   
    @Autowired
    private FunctionMapper functionMapper;

    @Test
    void toResponseDto_shouldCreateFunctionResponseDtoSuccessfully() {
        Event event = EventTestBuilder.anEvent().build();
        Function function = FunctionTestBuilder.aFunction().build();
        function.setEvent(event);

        FunctionResponseDto responseDto = functionMapper.toResponseDto(function);

        assertNotNull(responseDto);
        assertEquals(function.getId().toString(), responseDto.id());
        assertEquals(function.getEvent().getId().toString(), responseDto.eventId());
        assertEquals(function.getStartTime(), responseDto.startTime());
        assertEquals(function.getEndTime(), responseDto.endTime());
        assertEquals(function.getGuests(), responseDto.guests());
        assertEquals(function.getType().getId().toString(), responseDto.type().id());
        assertEquals(function.getVenue().getId().toString(), responseDto.venue().id());
        assertEquals(function.getSetup().getId().toString(), responseDto.setup().id());
    }
}
