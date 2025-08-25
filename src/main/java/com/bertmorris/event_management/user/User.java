package com.bertmorris.event_management.user;

import com.bertmorris.event_management.contact.Contact;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String providerId;

    private String syncKey;

    private Contact contact;

    public User() {}

    public User(String providerId, Contact contact) {
        this.providerId = providerId;
        this.contact = contact;
    }

    public Long getId() {
        return this.id;
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

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

}
