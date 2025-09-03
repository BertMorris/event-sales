package com.bertmorris.event_management.email;

import java.time.Instant;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import com.bertmorris.event_management.contact.Contact;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
    private boolean isRead;
    private Instant receivedAt;
    private Instant sentAt;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Contact sender;

    @ManyToMany
    @JoinTable(name = "email_to_recipients", joinColumns = @JoinColumn(name = "email_id"), inverseJoinColumns = @JoinColumn(name = "contact_id"))
    private List<Contact> toRecipients;

    @ManyToMany
    @JoinTable(name = "email_cc_recipients", joinColumns = @JoinColumn(name = "email_id"), inverseJoinColumns = @JoinColumn(name = "contact_id"))
    private List<Contact> ccRecipients;

    @ManyToMany
    @JoinTable(name = "email_bcc_recipients", joinColumns = @JoinColumn(name = "email_id"), inverseJoinColumns = @JoinColumn(name = "contact_id"))
    private List<Contact> bccRecipients;

    @ManyToMany
    @JoinTable(name = "email_reply_to", joinColumns = @JoinColumn(name = "email_id"), inverseJoinColumns = @JoinColumn(name = "contact_id"))
    private List<Contact> replyTo;
    
    @CreationTimestamp(source = SourceType.DB)
    private Instant createdAt;
    @UpdateTimestamp(source = SourceType.DB)
    private Instant updatedAt;

    // constructors
    public Email() {}
    
    // add recipients
    public void addToRecipient(Contact recipient) {
        this.toRecipients.add(recipient);
    }
    public void addCcRecipient(Contact recipient) {
        this.ccRecipients.add(recipient);
    }
    public void addBccRecipient(Contact recipient) {
        this.bccRecipients.add(recipient);
    }
    public void addReplyTo(Contact recipient) {
        this.replyTo.add(recipient);
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

    public boolean isRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
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

    public List<Contact> getToRecipients() {
        return toRecipients;
    }

    public void setToRecipients(List<Contact> toRecipients) {
        this.toRecipients = toRecipients;
    }

    public List<Contact> getCcRecipients() {
        return ccRecipients;
    }

    public void setCcRecipients(List<Contact> ccRecipients) {
        this.ccRecipients = ccRecipients;
    }

    public List<Contact> getBccRecipients() {
        return bccRecipients;
    }

    public void setBccRecipients(List<Contact> bccRecipients) {
        this.bccRecipients = bccRecipients;
    }

    public List<Contact> getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(List<Contact> replyTo) {
        this.replyTo = replyTo;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
    
}
