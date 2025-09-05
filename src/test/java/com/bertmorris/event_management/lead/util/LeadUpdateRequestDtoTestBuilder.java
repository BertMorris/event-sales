package com.bertmorris.event_management.lead.util;

import com.bertmorris.event_management.lead.LeadStatus;
import com.bertmorris.event_management.lead.dto.LeadUpdateRequestDto;

public class LeadUpdateRequestDtoTestBuilder {
    
    private LeadStatus status;
    private String company;
    private String title;
    private String description;
    private Integer budget;
    private String ownerId;
    private String contactId;

    public static LeadUpdateRequestDtoTestBuilder aLeadUpdateRequestDto() {
        return new LeadUpdateRequestDtoTestBuilder()
            .withStatus(LeadStatus.NEW)
            .withCompany("company")
            .withTitle("title")
            .withDescription("description")
            .withBudget(1000)
            .withOwnerId("1")
            .withContactId("1");
    }

    public LeadUpdateRequestDto build() {
        return new LeadUpdateRequestDto(status, company, title, description, budget, ownerId, contactId);
    }

    public LeadUpdateRequestDtoTestBuilder withStatus(LeadStatus status) {
        this.status = status;
        return this;
    }

    public LeadUpdateRequestDtoTestBuilder withCompany(String company) {
        this.company = company;
        return this;
    }

    public LeadUpdateRequestDtoTestBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public LeadUpdateRequestDtoTestBuilder withDescription(String description) {
        this.description = description;
        return this;
    }
    
    public LeadUpdateRequestDtoTestBuilder withBudget(Integer budget) {
        this.budget = budget;
        return this;
    }

    public LeadUpdateRequestDtoTestBuilder withOwnerId(String ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public LeadUpdateRequestDtoTestBuilder withContactId(String contactId) {
        this.contactId = contactId;
        return this;
    }
}
