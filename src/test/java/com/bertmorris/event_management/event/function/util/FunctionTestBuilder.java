package com.bertmorris.event_management.event.function.util;

import java.time.OffsetDateTime;

import org.springframework.test.util.ReflectionTestUtils;

import com.bertmorris.event_management.event.Event;
import com.bertmorris.event_management.event.function.Function;
import com.bertmorris.event_management.event.function.setup.FunctionSetup;
import com.bertmorris.event_management.event.function.setup.util.FunctionSetupTestBuilder;
import com.bertmorris.event_management.event.function.type.FunctionType;
import com.bertmorris.event_management.event.function.type.util.FunctionTypeTestBuilder;
import com.bertmorris.event_management.event.util.EventTestBuilder;
import com.bertmorris.event_management.user.User;
import com.bertmorris.event_management.user.util.UserTestBuilder;
import com.bertmorris.event_management.venue.Venue;
import com.bertmorris.event_management.venue.util.VenueTestBuilder;

public class FunctionTestBuilder {
    
    private Long id;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
    private Integer guests;
    private User owner;
    private Event event;
    private FunctionType type;
    private Venue venue;
    private FunctionSetup setup;
    
    public static FunctionTestBuilder aFunction() {
        return new FunctionTestBuilder()
            .withId(1L)
            .withStartTime(OffsetDateTime.now())
            .withEndTime(OffsetDateTime.now())
            .withGuests(100)
            .withOwner(UserTestBuilder.aUser().build())
            .withType(FunctionTypeTestBuilder.aFunctionType().build())
            .withVenue(VenueTestBuilder.aVenue().build())
            .withSetup(FunctionSetupTestBuilder.aFunctionSetup().build());
    }

    public Function build() {
        Function function = new Function();
        ReflectionTestUtils.setField(function, "id", this.id);
        function.setStartTime(this.startTime);
        function.setEndTime(this.endTime);
        function.setGuests(this.guests);
        function.setOwner(this.owner);
        function.setEvent(this.event);
        function.setType(this.type);
        function.setVenue(this.venue);
        function.setSetup(this.setup);

        return function;
    }

    public FunctionTestBuilder withId(Long id) {
        this.id = id;
        return this;
    }
    
    public FunctionTestBuilder withStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
        return this;
    }
    
    public FunctionTestBuilder withEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
        return this;
    }
    
    public FunctionTestBuilder withGuests(Integer guests) {
        this.guests = guests;
        return this;
    }

    public FunctionTestBuilder withOwner(User owner) {
        this.owner = owner;
        return this;
    }
    
    public FunctionTestBuilder withEvent(Event event) {
        this.event = event;
        return this;
    }

    public FunctionTestBuilder withType(FunctionType type) {
        this.type = type;
        return this;
    }
    
    public FunctionTestBuilder withVenue(Venue venue) {
        this.venue = venue;
        return this;
    }

    public FunctionTestBuilder withSetup(FunctionSetup setup) {
        this.setup = setup;
        return this;
    }
}
