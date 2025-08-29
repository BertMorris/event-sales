package com.bertmorris.event_management.event.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bertmorris.event_management.contact.Contact;
import com.bertmorris.event_management.event.Event;
import com.bertmorris.event_management.event.EventStatus;
import com.bertmorris.event_management.event.function.Function;
import com.bertmorris.event_management.event.type.EventType;
import com.bertmorris.event_management.lead.Lead;
import com.bertmorris.event_management.user.User;
import com.bertmorris.event_management.venue.Venue;

public class EventTestBuilder {

    private Long id;
    private EventStatus status;
    private String title;
    private String company;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer guests;
    private Integer rooms;
    private User owner;
    private Lead lead;
    private Contact contact;
    private EventType type;
    private Venue venue;
    private List<Function> functions;

    public static EventTestBuilder anEvent() {
        return new EventTestBuilder()
            .withId(1L)
            .withStatus(EventStatus.PROSPECT)
            .withTitle("title")
            .withCompany("company")
            .withStartDate(LocalDate.now())
            .withEndDate(LocalDate.now().plusDays(1))
            .withGuests(100)
            .withRooms(10)
            .withOwnerId(1L)
            .withLeadId(1L)
            .withContactId(1L)
            .withTypeId(1L)
            .withVenueId(1L)
            .withFunctions(new ArrayList<>());
    }

    public Event build() {
        return Event.builder()
            .id(this.id)
            .status(this.status)
            .title(this.title)
            .company(this.company)
            .startDate(this.startDate)
            .endDate(this.endDate)
            .guests(this.guests)
            .rooms(this.rooms)
            .owner(this.owner)
            .lead(this.lead)
            .contact(this.contact)
            .type(this.type)
            .venue(this.venue)
            .functions(this.functions)
            .build();
    }

    public EventTestBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public EventTestBuilder withStatus(EventStatus status) {
        this.status = status;
        return this;
    }

    public EventTestBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public EventTestBuilder withCompany(String company) {
        this.company = company;
        return this;
    }

    public EventTestBuilder withStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public EventTestBuilder withEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public EventTestBuilder withGuests(Integer guests) {
        this.guests = guests;
        return this;
    }

    public EventTestBuilder withRooms(Integer rooms) {
        this.rooms = rooms;
        return this;
    }

    public EventTestBuilder withOwner(User owner) {
        this.owner = owner;
        return this;
    }

    public EventTestBuilder withOwnerId(Long ownerId) {
        this.owner = ownerId == null ? null : User.builder().id(ownerId).build();
        return this;
    }

    public EventTestBuilder withLead(Lead lead) {
        this.lead = lead;
        return this;
    }

    public EventTestBuilder withLeadId(Long leadId) {
        this.lead = leadId == null ? null : Lead.builder().id(leadId).build();
        return this;
    }

    public EventTestBuilder withContact(Contact contact) {
        this.contact = contact;
        return this;
    }

    public EventTestBuilder withContactId(Long contactId) {
        this.contact = contactId == null ? null : Contact.builder().id(contactId).build();
        return this;
    }

    public EventTestBuilder withType(EventType type) {
        this.type = type;
        return this;
    }

    public EventTestBuilder withTypeId(Long typeId) {
        this.type = typeId == null ? null : EventType.builder().id(typeId).build();
        return this;
    }

    public EventTestBuilder withVenue(Venue venue) {
        this.venue = venue;
        return this;
    }

    public EventTestBuilder withVenueId(Long venueId) {
        this.venue = venueId == null ? null : Venue.builder().id(venueId).build();
        return this;
    }

    public EventTestBuilder withFunctions(List<Function> functions) {
        this.functions = functions;
        return this;
    }

    public EventTestBuilder addFunction(Function function) {
        if (this.functions == null) {
            this.functions = new ArrayList<>();
        }
        this.functions.add(function);
        return this;
    }
}