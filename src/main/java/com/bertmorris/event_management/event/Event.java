package com.bertmorris.event_management.event;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

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
    private String title;
    private String company;
    private LocalDate startDate;
    private LocalDate endDate;
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

    @CreationTimestamp(source = SourceType.DB)
    private Instant createdAt;
    @UpdateTimestamp(source = SourceType.DB)
    private Instant updatedAt;

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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }   

    public void setEndDate(LocalDate endDate) {
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

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    // builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
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
        private Instant createdAt;
        private Instant updatedAt;


        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder status(EventStatus status) {
            this.status = status;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }
        
        public Builder company(String company) {
            this.company = company;
            return this;
        }
        
        
        public Builder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }
        
        
        public Builder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }
        
        
        public Builder guests(Integer guests) {
            this.guests = guests;
            return this;
        }
        
        
        public Builder rooms(Integer rooms) {
            this.rooms = rooms;
            return this;
        }
        
        public Builder owner(User owner) {
            this.owner = owner;
            return this;
        }
        
        
        public Builder lead(Lead lead) {
            this.lead = lead;
            return this;
        }
        
        
        public Builder contact(Contact contact) {
            this.contact = contact;
            return this;
        }
        
        
        public Builder type(EventType type) {
            this.type = type;
            return this;
        }
        
        
        public Builder venue(Venue venue) {
            this.venue = venue;
            return this;
        }
        
        
        public Builder functions(List<Function> functions) {
            this.functions = functions;
            return this;
        }
        
        
        public Builder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        
        
        public Builder updatedAt(Instant updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }
        
        
        public Event build() {
            Event event = new Event();

            event.id = id;
            event.status = status;
            event.title = title;
            event.company = company;
            event.startDate = startDate;
            event.endDate = endDate;
            event.guests = guests;
            event.rooms = rooms;
            event.owner = owner;
            event.lead = lead;
            event.contact = contact;
            event.type = type;
            event.venue = venue;
            event.functions = functions;
            event.createdAt = createdAt;
            event.updatedAt = updatedAt;

            return event;
        }
    }
}
