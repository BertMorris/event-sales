package com.bertmorris.event_management.users;

import com.bertmorris.event_management.contacts.Contact;

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

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

}
