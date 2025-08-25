package com.bertmorris.event_management.event.function;

import java.time.LocalDateTime;

import com.bertmorris.event_management.event.function.setup.FunctionSetup;
import com.bertmorris.event_management.event.function.type.FunctionType;
import com.bertmorris.event_management.user.User;
import com.bertmorris.event_management.venue.Venue;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "function")
public class Function {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer guests;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private FunctionType type;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @ManyToOne
    @JoinColumn(name = "setup_id")
    private FunctionSetup setup;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    // constructors
    public Function() {}

    // getters and setters
    public Long getId() {
        return id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    
    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Integer getGuests() {
        return guests;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public FunctionType getType() {
        return type;
    }

    public void setType(FunctionType type) {
        this.type = type;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public FunctionSetup getSetup() {
        return setup;
    }

    public void setSetup(FunctionSetup setup) {
        this.setup = setup;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

}
