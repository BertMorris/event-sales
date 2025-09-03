package com.bertmorris.event_management.email.provider.util;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.graph.models.EmailAddress;
import com.microsoft.graph.models.ItemBody;
import com.microsoft.graph.models.Message;
import com.microsoft.graph.models.Recipient;

public class GraphMessageTestBuilder {
    
    private String id;
    private String subject;
    private ItemBody body;
    private String conversationId;
    private boolean hasAttachments;
    private boolean isRead;
    private OffsetDateTime receivedDateTime;
    private OffsetDateTime sentDateTime;
    private Recipient sender;
    private List<Recipient> recipients;
    private List<Recipient> ccRecipients;
    private List<Recipient> bccRecipients;
    private List<Recipient> replyTo;

    public static GraphMessageTestBuilder aMessage() {
        return new GraphMessageTestBuilder()
            .withId("graph-id")
            .withSubject("subject")
            .withBody(textBody("body"))
            .withConversationId("conversation-id")
            .withHasAttachments(false)
            .withIsRead(false)
            .withSentDateTime(OffsetDateTime.now().minusHours(1))
            .withReceivedDateTime(OffsetDateTime.now())
            .withSender(recipient("sender", "sender@example.com"))
            .withRecipients(listOf(recipient("to", "to@example.com")))
            .withCcRecipients(listOf(recipient("cc", "cc@example.com")))
            .withBccRecipients(listOf(recipient("bcc", "bcc@example.com")))
            .withReplyTo(listOf(recipient("replyto", "replyto@example.com")));
    }

    public Message build() {
        Message message = new Message();
        message.setId(this.id);
        message.setSubject(this.subject);
        message.setBody(this.body);
        message.setConversationId(this.conversationId);
        message.setHasAttachments(this.hasAttachments);
        message.setIsRead(this.isRead);
        message.setReceivedDateTime(this.receivedDateTime);
        message.setSentDateTime(this.sentDateTime);
        message.setSender(this.sender);
        message.setToRecipients(this.recipients);
        message.setCcRecipients(this.ccRecipients);
        message.setBccRecipients(this.bccRecipients);
        message.setReplyTo(this.replyTo);
        return message;
    }

    public GraphMessageTestBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public GraphMessageTestBuilder withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public GraphMessageTestBuilder withBody(ItemBody body) {
        this.body = body;
        return this;
    }

    public GraphMessageTestBuilder withConversationId(String conversationId) {
        this.conversationId = conversationId;
        return this;
    }

    public GraphMessageTestBuilder withHasAttachments(boolean hasAttachments) {
        this.hasAttachments = hasAttachments;
        return this;
    }

    public GraphMessageTestBuilder withIsRead(boolean isRead) {
        this.isRead = isRead;
        return this;
    }

    public GraphMessageTestBuilder withReceivedDateTime(OffsetDateTime receivedDateTime) {
        this.receivedDateTime = receivedDateTime;
        return this;
    }

    public GraphMessageTestBuilder withSentDateTime(OffsetDateTime sentDateTime) {
        this.sentDateTime = sentDateTime;
        return this;
    }

    public GraphMessageTestBuilder withSender(Recipient sender) {
        this.sender = sender;
        return this;
    }

    public GraphMessageTestBuilder withRecipients(List<Recipient> recipients) {
        this.recipients = recipients;
        return this;
    }

    public GraphMessageTestBuilder withCcRecipients(List<Recipient> ccRecipients) {
        this.ccRecipients = ccRecipients;
        return this;
    }

    public GraphMessageTestBuilder withBccRecipients(List<Recipient> bccRecipients) {
        this.bccRecipients = bccRecipients;
        return this;
    }

    public GraphMessageTestBuilder withReplyTo(List<Recipient> replyTo) {
        this.replyTo = replyTo;
        return this;
    }

    private static Recipient recipient(String name, String address) {
        EmailAddress emailAddress = new EmailAddress();
        emailAddress.setName(name);
        emailAddress.setAddress(address);
        Recipient recipient = new Recipient();
        recipient.setEmailAddress(emailAddress);
        return recipient;
    }

    private static ItemBody textBody(String content) {
        ItemBody itemBody = new ItemBody();
        itemBody.setContent(content);
        return itemBody;
    }

    private static List<Recipient> listOf(Recipient recipient) {
        List<Recipient> list = new ArrayList<>();
        list.add(recipient);
        return list;
    }
    
}
