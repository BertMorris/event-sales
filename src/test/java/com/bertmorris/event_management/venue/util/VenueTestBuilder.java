package com.bertmorris.event_management.venue.util;

import com.bertmorris.event_management.venue.Venue;

public class VenueTestBuilder {

    private Long id;
    private String name;
    private Integer capacity;

    public static VenueTestBuilder aVenue() {
        return new VenueTestBuilder()
            .withId(1L)
            .withName("venue")
            .withCapacity(100);
    }

    public Venue build() {
        return Venue.builder()
            .id(this.id)
            .name(this.name)
            .capacity(this.capacity)
            .build();
    }

    public VenueTestBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public VenueTestBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public VenueTestBuilder withCapacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }
}


