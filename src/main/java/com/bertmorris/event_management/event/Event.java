package com.bertmorris.event_management.event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bertmorris.event_management.contact.Contact;
import com.bertmorris.event_management.event.function.Function;
import com.bertmorris.event_management.event.type.EventType;
import com.bertmorris.event_management.lead.Lead;
import com.bertmorris.event_management.user.User;
import com.bertmorris.event_management.venue.Venue;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "event")
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private EventStatus status;
    private String company;
    private Date startDate;
    private Date endDate;
    private Integer guests;
    private Integer rooms;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "lead_id")
    private Lead lead;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private EventType type;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @OneToMany(mappedBy = "event")
    private List<Function> functions = new ArrayList<>();

    // constructors
    public Event() {}

    // getters and setters
    public Long getId() {
        return this.id;
    }

    public User getOwner() {
        return this.owner;
    }

    public Lead getLead() {
        return this.lead;
    }

    public void setLead(Lead lead) {
        this.lead = lead;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public EventStatus getStatus() {
        return this.status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public EventType getType() {
        return this.type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }   

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Venue getVenue() {
        return this.venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Integer getGuests() {
        return this.guests;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    public Integer getRooms() {
        return this.rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public List<Function> getFunctions() {
        return this.functions;
    }

    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }

    public void addFunction(Function function) {
        this.functions.add(function);
    }
    
}
