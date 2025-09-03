package com.bertmorris.event_management.email;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import com.bertmorris.event_management.contact.Contact;
import com.bertmorris.event_management.email.recipient.EmailRecipient;
import com.bertmorris.event_management.email.recipient.EmailRecipientType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "email")
public class Email {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false, updatable = false)
    private String providerId;

    private String subject;
    private String body;
    private String conversationId;
    private boolean hasAttachments;
    private Instant readAt;
    private Instant receivedAt;
    private Instant sentAt;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Contact sender;

    @OneToMany(mappedBy = "email")
    private List<EmailRecipient> recipients = new ArrayList<>();
    
    
    @CreationTimestamp(source = SourceType.DB)
    private Instant createdAt;
    @UpdateTimestamp(source = SourceType.DB)
    private Instant updatedAt;

    // constructors
    public Email() {}
    
    // add recipients
    public void addToRecipient(Contact recipient) {
        this.recipients.add(new EmailRecipient(this.id, recipient.getId(), EmailRecipientType.TO));
    }
    public void addCcRecipient(Contact recipient) {
        this.recipients.add(new EmailRecipient(this.id, recipient.getId(), EmailRecipientType.CC));
    }
    public void addBccRecipient(Contact recipient) {
        this.recipients.add(new EmailRecipient(this.id, recipient.getId(), EmailRecipientType.BCC));
    }
    public void addReplyTo(Contact recipient) {
        this.recipients.add(new EmailRecipient(this.id, recipient.getId(), EmailRecipientType.REPLY_TO));
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public boolean hasAttachments() {
        return hasAttachments;
    }

    public void setHasAttachments(boolean hasAttachments) {
        this.hasAttachments = hasAttachments;
    }

    public Instant getReadAt() {
        return readAt;
    }

    public void setReadAt(Instant readAt) {
        this.readAt = readAt;
    }

    public Instant getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(Instant receivedAt) {
        this.receivedAt = receivedAt;
    }

    public Instant getSentAt() {
        return sentAt;
    }

    public void setSentAt(Instant sentAt) {
        this.sentAt = sentAt;
    }

    public Contact getSender() {
        return sender;
    }

    public void setSender(Contact sender) {
        this.sender = sender;
    }

    public List<EmailRecipient> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<EmailRecipient> recipients) {
        this.recipients = recipients;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
    
}
