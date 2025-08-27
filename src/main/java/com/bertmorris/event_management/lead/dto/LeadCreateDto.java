package com.bertmorris.event_management.lead.dto;

import com.bertmorris.event_management.lead.LeadStatus;

import jakarta.validation.constraints.NotNull;

public record LeadCreateDto(
    @NotNull LeadStatus status,
    String company,
    String title,
    String description,
    Integer budget,
    @NotNull Long ownerId, // going with ids for now
    @NotNull Long contactId
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private LeadStatus status;
        private String company;
        private String title;
        private String description;
        private Integer budget;
        private Long ownerId;
        private Long contactId;

        public Builder status(LeadStatus status) {
            this.status = status;
            return this;
        }

        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder budget(Integer budget) {
            this.budget = budget;
            return this;
        }

        public Builder ownerId(Long ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public Builder contactId(Long contactId) {
            this.contactId = contactId;
            return this;
        }

        public LeadCreateDto build() {
            return new LeadCreateDto(status, company, title, description, budget, ownerId, contactId);
        }
    }
}