package com.bertmorris.event_management.event.util;

import java.time.LocalDate;

import com.bertmorris.event_management.event.EventStatus;
import com.bertmorris.event_management.event.dto.EventCreateDto;

public class EventCreateDtoTestBuilder {

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

    public static EventCreateDtoTestBuilder anEventCreateDto() {
        return new EventCreateDtoTestBuilder()
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

    public EventCreateDto build() {
        return new EventCreateDto(
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

    public EventCreateDtoTestBuilder withOwnerId(Long ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public EventCreateDtoTestBuilder withLeadId(Long leadId) {
        this.leadId = leadId;
        return this;
    }

    public EventCreateDtoTestBuilder withStatus(EventStatus status) {
        this.status = status;
        return this;
    }

    public EventCreateDtoTestBuilder withTypeId(Long typeId) {
        this.typeId = typeId;
        return this;
    }

    public EventCreateDtoTestBuilder withContactId(Long contactId) {
        this.contactId = contactId;
        return this;
    }

    public EventCreateDtoTestBuilder withCompany(String company) {
        this.company = company;
        return this;
    }

    public EventCreateDtoTestBuilder withStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public EventCreateDtoTestBuilder withEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public EventCreateDtoTestBuilder withVenueId(Long venueId) {
        this.venueId = venueId;
        return this;
    }

    public EventCreateDtoTestBuilder withGuests(Integer guests) {
        this.guests = guests;
        return this;
    }

    public EventCreateDtoTestBuilder withRooms(Integer rooms) {
        this.rooms = rooms;
        return this;
    }
}