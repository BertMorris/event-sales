package com.bertmorris.event_management.event.dto;

import java.time.LocalDate;

import com.bertmorris.event_management.event.EventStatus;

public record EventUpdateRequestDto(
    String ownerId,
    String leadId,
    EventStatus status,
    String typeId,
    String contactId,
    String company,
    LocalDate startDate,
    LocalDate endDate,
    String venueId,
    Integer guests,
    Integer rooms
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String ownerId;
        private String leadId;
        private EventStatus status;
        private String typeId;
        private String contactId;
        private String company;
        private LocalDate startDate;
        private LocalDate endDate;
        private String venueId;
        private Integer guests;
        private Integer rooms;

        public Builder ownerId(String ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public Builder leadId(String leadId) {
            this.leadId = leadId;
            return this;
        }
        
        public Builder status(EventStatus status) {
            this.status = status;
            return this;
        }
        
        public Builder typeId(String typeId) {
            this.typeId = typeId;
            return this;
        }
        
        
        public Builder contactId(String contactId) {
            this.contactId = contactId;
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
        
        public Builder venueId(String venueId) {
            this.venueId = venueId;
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
        
        public EventUpdateRequestDto build() {
            return new EventUpdateRequestDto(ownerId, leadId, status, typeId, contactId, company, startDate, endDate, venueId, guests, rooms);
        }
    }
}
