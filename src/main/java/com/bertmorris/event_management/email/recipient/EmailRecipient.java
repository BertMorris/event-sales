package com.bertmorris.event_management.email.recipient;

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
    private Long emailId;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Long contactId;

    // constructors
    public EmailRecipient() {};

    public EmailRecipient(Long emailId, Long contactId, EmailRecipientType type) {
        this.emailId = emailId;
        this.contactId = contactId;
        this.type = type;
    }

    // getters and setters
    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public EmailRecipientType getType() {
        return type;
    }

    public void setType(EmailRecipientType type) {
        this.type = type;
    }
}