package com.bertmorris.event_management.user;

import java.time.OffsetDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String providerId;
    private String syncKey;

    @CreationTimestamp(source = SourceType.DB)
    private OffsetDateTime createdAt;
    @UpdateTimestamp(source = SourceType.DB)
    private OffsetDateTime updatedAt;

    // constructors
    public User() {}

    public User(String providerId) {
        this.providerId = providerId;
    }

    // methods
    public void updateSyncKey(String syncKey) {
        this.syncKey = syncKey;
    }

    // getters and setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        if (this.id != null && !this.id.equals(id)) {
            throw new IllegalStateException("Id cannot be changed");
        }
        
        this.id = id;
    }

    public String getProviderId() {
        return this.providerId;
    }

    public String getSyncKey() {
        return this.syncKey;
    }

    public void setSyncKey(String syncKey) {
        this.syncKey = syncKey;
    }

    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    // builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String providerId;
        private String syncKey;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder providerId(String providerId) { this.providerId = providerId; return this; }
        public Builder syncKey(String syncKey) { this.syncKey = syncKey; return this; }
        public Builder createdAt(OffsetDateTime createdAt) { this.createdAt = createdAt; return this; }
        public Builder updatedAt(OffsetDateTime updatedAt) { this.updatedAt = updatedAt; return this; }

        public User build() {
            User user = new User();

            user.id = id;
            user.providerId = providerId;
            user.syncKey = syncKey;
            user.createdAt = createdAt;
            user.updatedAt = updatedAt;

            return user;
        }
    }
}
