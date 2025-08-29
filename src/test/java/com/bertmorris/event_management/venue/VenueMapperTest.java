package com.bertmorris.event_management.venue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bertmorris.event_management.venue.dto.VenueResponseDto;
import com.bertmorris.event_management.venue.util.VenueTestBuilder;

@ExtendWith(SpringExtension.class)
@Import(VenueMapperImpl.class)
public class VenueMapperTest {

    @Autowired
    private VenueMapper venueMapper;

    @Test
    void toResponseDto_shouldCreateVenueResponseDtoSuccessfully() {
        Venue venue = VenueTestBuilder.aVenue().build();

        VenueResponseDto responseDto = venueMapper.toResponseDto(venue);

        assertNotNull(responseDto);
        assertEquals(venue.getId().toString(), responseDto.id());
        assertEquals(venue.getName(), responseDto.name());
        assertEquals(venue.getCapacity(), responseDto.capacity());
    }
}