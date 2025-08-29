package com.bertmorris.event_management.lead;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import com.bertmorris.event_management.contact.Contact;
import com.bertmorris.event_management.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lead")
public class Lead {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(value = EnumType.STRING)
    private LeadStatus status;
    private String company;
    private String title;
    private String description;
    private Integer budget;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @CreationTimestamp(source = SourceType.DB)
    private Instant createdAt;
    @UpdateTimestamp(source = SourceType.DB)
    private Instant updatedAt;

    // constructors
    public Lead() {}
    
    // getters and setters
    public Long getId() {
        return id;
    }

    public LeadStatus getStatus() {
        return status;
    }

    public void setStatus(LeadStatus status) {
        this.status = status;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    // builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private LeadStatus status;
        private String company;
        private String title;
        private String description;
        private Integer budget;
        private User owner;
        private Contact contact;
        private Instant createdAt;
        private Instant updatedAt;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder status(LeadStatus status) { this.status = status; return this; }
        public Builder company(String company) { this.company = company; return this; }
        public Builder title(String title) { this.title = title; return this; }
        public Builder description(String description) { this.description = description; return this; }
        public Builder budget(Integer budget) { this.budget = budget; return this; }
        public Builder owner(User owner) { this.owner = owner; return this; }
        public Builder contact(Contact contact) { this.contact = contact; return this; }
        public Builder createdAt(Instant createdAt) { this.createdAt = createdAt; return this; }
        public Builder updatedAt(Instant updatedAt) { this.updatedAt = updatedAt; return this; }

        public Lead build() {
            Lead lead = new Lead();

            lead.id = id;
            lead.status = status;
            lead.company = company;
            lead.title = title;
            lead.description = description;
            lead.budget = budget;
            lead.owner = owner;
            lead.contact = contact;
            lead.createdAt = createdAt;
            lead.updatedAt = updatedAt;

            return lead;
        }
    }
}