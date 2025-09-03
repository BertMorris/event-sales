package com.bertmorris.event_management.email.recipient;

import com.bertmorris.event_management.contact.Contact;
import com.bertmorris.event_management.email.Email;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EmailRecipient {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private EmailRecipientType type;

    @ManyToOne
    @JoinColumn(name = "email_id")
    private Email email;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    // constructors
    public EmailRecipient() {};

    public EmailRecipient(Email email, Contact contact, EmailRecipientType type) {
        this.email = email;
        this.contact = contact;
        this.type = type;
    }

    // getters and setters
    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public EmailRecipientType getType() {
        return type;
    }

    public void setType(EmailRecipientType type) {
        this.type = type;
    }
}