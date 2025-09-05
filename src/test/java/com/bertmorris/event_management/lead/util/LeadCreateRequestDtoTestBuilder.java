package com.bertmorris.event_management.lead.util;

import com.bertmorris.event_management.lead.LeadStatus;
import com.bertmorris.event_management.lead.dto.LeadCreateRequestDto;

public class LeadCreateRequestDtoTestBuilder {
    
    private LeadStatus status;
    private String company;
    private String title;
    private String description;
    private Integer budget;
    private String contactId;

    public static LeadCreateRequestDtoTestBuilder aLeadCreateRequestDto() {
        return new LeadCreateRequestDtoTestBuilder()
            .withStatus(LeadStatus.NEW)
            .withCompany("company")
            .withTitle("title")
            .withDescription("description")
            .withBudget(1000)
            .withContactId("1");
    }

    public LeadCreateRequestDto build() {
        return new LeadCreateRequestDto(status, company, title, description, budget, contactId);
    }

    public LeadCreateRequestDtoTestBuilder withStatus(LeadStatus status) {
        this.status = status;
        return this;
    }

    public LeadCreateRequestDtoTestBuilder withCompany(String company) {
        this.company = company;
        return this;
    }

    public LeadCreateRequestDtoTestBuilder withTitle(String title) {
        this.title = title;
        return this;
    }
    
    public LeadCreateRequestDtoTestBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public LeadCreateRequestDtoTestBuilder withBudget(Integer budget) {
        this.budget = budget;
        return this;
    }

    public LeadCreateRequestDtoTestBuilder withContactId(String contactId) {
        this.contactId = contactId;
        return this;
    }
}
