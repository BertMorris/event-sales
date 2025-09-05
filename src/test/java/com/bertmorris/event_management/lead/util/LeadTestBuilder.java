package com.bertmorris.event_management.lead.util;

import org.springframework.test.util.ReflectionTestUtils;

import com.bertmorris.event_management.contact.Contact;
import com.bertmorris.event_management.contact.util.ContactTestBuilder;
import com.bertmorris.event_management.lead.Lead;
import com.bertmorris.event_management.lead.LeadStatus;
import com.bertmorris.event_management.user.User;
import com.bertmorris.event_management.user.util.UserTestBuilder;

public class LeadTestBuilder {
   
    private Long id;
    private LeadStatus status;
    private String company;
    private String title;
    private String description;
    private Integer budget;
    private User owner;
    private Contact contact;

    public static LeadTestBuilder aLead() {
        return new LeadTestBuilder()
            .withId(1L)
            .withStatus(LeadStatus.NEW)
            .withCompany("company")
            .withTitle("title")
            .withDescription("description")
            .withBudget(1000)
            .withOwner(UserTestBuilder.aUser().build())
            .withContact(ContactTestBuilder.aContact().build());
    }

    public Lead build() {
        Lead lead = new Lead();
        ReflectionTestUtils.setField(lead, "id", this.id);
        lead.setStatus(this.status);
        lead.setCompany(this.company);
        lead.setTitle(this.title);
        lead.setDescription(this.description);
        lead.setBudget(this.budget);
        lead.setOwner(this.owner);
        lead.setContact(this.contact);
        
        return lead;
    }

    public LeadTestBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public LeadTestBuilder withStatus(LeadStatus status) {
        this.status = status;
        return this;
    }

    public LeadTestBuilder withCompany(String company) {
        this.company = company;
        return this;
    }

    public LeadTestBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public LeadTestBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public LeadTestBuilder withBudget(Integer budget) {
        this.budget = budget;
        return this;
    }

    public LeadTestBuilder withOwner(User owner) {
        this.owner = owner;
        return this;
    }

    public LeadTestBuilder withContact(Contact contact) {
        this.contact = contact;
        return this;
    }
}