package com.bertmorris.event_management.event.util;

import java.time.LocalDate;

import com.bertmorris.event_management.event.EventStatus;
import com.bertmorris.event_management.event.dto.EventUpdateDto;

public class EventUpdateDtoTestBuilder {

    private Long id;
    private Long ownerId;
    private Long leadId;
    private EventStatus status;
    private Long typeId;
    private Long contactId;
    private String company;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long venueId;
    private Integer guests;
    private Integer rooms;

    public static EventUpdateDtoTestBuilder anEventUpdateDto() {
        return new EventUpdateDtoTestBuilder()
            .withId(1L)
            .withOwnerId(1L)
            .withLeadId(1L)
            .withStatus(EventStatus.PROSPECT)
            .withTypeId(1L)
            .withContactId(1L)
            .withCompany("company")
            .withStartDate(LocalDate.now())
            .withEndDate(LocalDate.now().plusDays(1))
            .withVenueId(1L)
            .withGuests(100)
            .withRooms(10);
    }

    public EventUpdateDto build() {
        return new EventUpdateDto(
            this.id,
            this.ownerId,
            this.leadId,
            this.status,
            this.typeId,
            this.contactId,
            this.company,
            this.startDate,
            this.endDate,
            this.venueId,
            this.guests,
            this.rooms
        );
    }

    public EventUpdateDtoTestBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public EventUpdateDtoTestBuilder withOwnerId(Long ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public EventUpdateDtoTestBuilder withLeadId(Long leadId) {
        this.leadId = leadId;
        return this;
    }

    public EventUpdateDtoTestBuilder withStatus(EventStatus status) {
        this.status = status;
        return this;
    }

    public EventUpdateDtoTestBuilder withTypeId(Long typeId) {
        this.typeId = typeId;
        return this;
    }

    public EventUpdateDtoTestBuilder withContactId(Long contactId) {
        this.contactId = contactId;
        return this;
    }

    public EventUpdateDtoTestBuilder withCompany(String company) {
        this.company = company;
        return this;
    }

    public EventUpdateDtoTestBuilder withStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public EventUpdateDtoTestBuilder withEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public EventUpdateDtoTestBuilder withVenueId(Long venueId) {
        this.venueId = venueId;
        return this;
    }

    public EventUpdateDtoTestBuilder withGuests(Integer guests) {
        this.guests = guests;
        return this;
    }

    public EventUpdateDtoTestBuilder withRooms(Integer rooms) {
        this.rooms = rooms;
        return this;
    }
}


