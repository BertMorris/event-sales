package com.bertmorris.event_management.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bertmorris.event_management.contact.ContactMapperImpl;
import com.bertmorris.event_management.event.dto.EventCreateDto;
import com.bertmorris.event_management.event.dto.EventCreateRequestDto;
import com.bertmorris.event_management.event.dto.EventDetailResponseDto;
import com.bertmorris.event_management.event.dto.EventSummaryResponseDto;
import com.bertmorris.event_management.event.dto.EventUpdateDto;
import com.bertmorris.event_management.event.dto.EventUpdateRequestDto;
import com.bertmorris.event_management.event.function.FunctionMapperImpl;
import com.bertmorris.event_management.event.function.setup.FunctionSetupMapperImpl;
import com.bertmorris.event_management.event.function.type.FunctionTypeMapperImpl;
import com.bertmorris.event_management.event.type.EventTypeMapperImpl;
import com.bertmorris.event_management.event.util.EventCreateDtoTestBuilder;
import com.bertmorris.event_management.event.util.EventTestBuilder;
import com.bertmorris.event_management.event.util.EventUpdateDtoTestBuilder;
import com.bertmorris.event_management.lead.LeadMapperImpl;
import com.bertmorris.event_management.user.UserMapperImpl;
import com.bertmorris.event_management.venue.VenueMapperImpl;

@ExtendWith(SpringExtension.class)
@Import({EventMapperImpl.class,
    EventTypeMapperImpl.class,
    FunctionMapperImpl.class,
    FunctionTypeMapperImpl.class,
    FunctionSetupMapperImpl.class,
    LeadMapperImpl.class,
    UserMapperImpl.class,
    ContactMapperImpl.class, 
    VenueMapperImpl.class
})
public class EventMapperTest {

    @Autowired
    private EventMapper eventMapper;

    @Test
    void toCreateDto_shouldCreateEventCreateDtoSuccessfully() {
        EventCreateRequestDto requestDto = EventCreateRequestDto.builder()
            .ownerId("1")
            .leadId("2")
            .status(EventStatus.PROSPECT)
            .typeId("1")
            .contactId("3")
            .company("company")
            .guests(100)
            .rooms(10)
            .startDate(LocalDate.now())
            .endDate(LocalDate.now().plusDays(1))
            .build();

        EventCreateDto eventCreateDto = eventMapper.toCreateDto(requestDto);

        assertEquals(Long.valueOf(requestDto.ownerId()), eventCreateDto.ownerId());
        assertEquals(Long.valueOf(requestDto.leadId()), eventCreateDto.leadId());
        assertEquals(requestDto.status(), eventCreateDto.status());
        assertEquals(Long.valueOf(requestDto.typeId()), eventCreateDto.typeId());
        assertEquals(Long.valueOf(requestDto.contactId()), eventCreateDto.contactId());
        assertEquals(requestDto.company(), eventCreateDto.company());
        assertEquals(requestDto.guests(), eventCreateDto.guests());
        assertEquals(requestDto.rooms(), eventCreateDto.rooms());
        assertEquals(requestDto.startDate(), eventCreateDto.startDate());
        assertEquals(requestDto.endDate(), eventCreateDto.endDate());
    }

    @Test
    void toUpdateDto_shouldCreateEventUpdateDtoSuccessfully() {
        Long id = 1L;
        EventUpdateRequestDto requestDto = EventUpdateRequestDto.builder()
            .ownerId("1")
            .leadId("2")
            .status(EventStatus.PROSPECT)
            .typeId("1")
            .contactId("3")
            .company("company")
            .startDate(LocalDate.now())
            .endDate(LocalDate.now().plusDays(1))
            .venueId("4")
            .guests(100)
            .rooms(10)
            .build();

        EventUpdateDto eventUpdateDto = eventMapper.toUpdateDto(id, requestDto);

        assertNotNull(eventUpdateDto);
        assertEquals(id, eventUpdateDto.id());
        assertEquals(Long.valueOf(requestDto.ownerId()), eventUpdateDto.ownerId());
        assertEquals(Long.valueOf(requestDto.leadId()), eventUpdateDto.leadId());
        assertEquals(requestDto.status(), eventUpdateDto.status());
        assertEquals(Long.valueOf(requestDto.typeId()), eventUpdateDto.typeId());
        assertEquals(Long.valueOf(requestDto.contactId()), eventUpdateDto.contactId());
        assertEquals(requestDto.company(), eventUpdateDto.company());
        assertEquals(requestDto.startDate(), eventUpdateDto.startDate());
        assertEquals(requestDto.endDate(), eventUpdateDto.endDate());
        assertEquals(Long.valueOf(requestDto.venueId()), eventUpdateDto.venueId());
        assertEquals(requestDto.guests(), eventUpdateDto.guests());
        assertEquals(requestDto.rooms(), eventUpdateDto.rooms());
    }

    @Test
    void toSummaryResponseDto_shouldCreateEventSummaryResponseDtoSuccessfully() {
        Event event = EventTestBuilder.anEvent().build();

        EventSummaryResponseDto eventSummaryResponseDto = eventMapper.toSummaryResponseDto(event);

        assertNotNull(eventSummaryResponseDto);
        assertEquals(event.getId().toString(), eventSummaryResponseDto.id());
        assertEquals(event.getLead().getId().toString(), eventSummaryResponseDto.leadId());
        assertEquals(event.getStatus(), eventSummaryResponseDto.status());
        assertEquals(event.getType().getId().toString(), eventSummaryResponseDto.typeId());
        assertEquals(event.getContact().getId().toString(), eventSummaryResponseDto.contactId());
        assertEquals(event.getCompany(), eventSummaryResponseDto.company());
        assertEquals(event.getStartDate(), eventSummaryResponseDto.startDate());
        assertEquals(event.getEndDate(), eventSummaryResponseDto.endDate());
        assertEquals(event.getVenue().getId().toString(), eventSummaryResponseDto.venueId());
        assertEquals(event.getGuests(), eventSummaryResponseDto.guests());
        assertEquals(event.getRooms(), eventSummaryResponseDto.rooms());
    }

    @Test
    void toDetailResponseDto_shouldCreateEventDetailResponseDtoSuccessfully() {
        Event event = EventTestBuilder.anEvent().build();

        EventDetailResponseDto eventDetailResponseDto = eventMapper.toDetailResponseDto(event);
        
        assertNotNull(eventDetailResponseDto);
        assertEquals(event.getId().toString(), eventDetailResponseDto.id());
        assertEquals(event.getLead().getId().toString(), eventDetailResponseDto.leadId());
        assertEquals(event.getStatus(), eventDetailResponseDto.status());
        assertEquals(event.getType().getId().toString(), eventDetailResponseDto.typeId());
        assertEquals(event.getContact().getId().toString(), eventDetailResponseDto.contactId());
        assertEquals(event.getCompany(), eventDetailResponseDto.company());
        assertEquals(event.getStartDate(), eventDetailResponseDto.startDate());
        assertEquals(event.getEndDate(), eventDetailResponseDto.endDate());
        assertEquals(event.getVenue().getId().toString(), eventDetailResponseDto.venueId());
        assertEquals(event.getGuests(), eventDetailResponseDto.guests());
        assertEquals(event.getRooms(), eventDetailResponseDto.rooms());
    }

}