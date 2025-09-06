package com.bertmorris.event_management.email.provider;

import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.microsoft.graph.users.item.mailfolders.item.messages.delta.DeltaGetResponse;
import com.microsoft.graph.models.Message;
import com.microsoft.graph.serviceclient.GraphServiceClient;

@Component
public class EmailProvider {

    private final EmailClientFactory emailClientFactory;
    private final EmailProviderMapper emailProviderMapper;
    private final ApplicationEventPublisher applicationEventPublisher;
    
    public EmailProvider(EmailClientFactory emailClientFactory, EmailProviderMapper emailProviderMapper, ApplicationEventPublisher applicationEventPublisher) {
        this.emailClientFactory = emailClientFactory;
        this.emailProviderMapper = emailProviderMapper;
        this.applicationEventPublisher = applicationEventPublisher;
    }
    
    public void syncEmails(String oboToken, String syncKey, Long userId) {
        GraphServiceClient graphClient = emailClientFactory.getGraphServiceClient(oboToken);

        DeltaGetResponse response =  graphClient.me()
            .mailFolders()
            .byMailFolderId("inbox")
            .messages()
            .delta()
            .withUrl(syncKey)
            .get(requestConfiguration -> {
                requestConfiguration.headers.add("Prefer", "outlook.body-content-type=\"text\"");
                requestConfiguration.queryParameters.select = new String[] { 
                    "id", "subject", "body", "conversationId", "hasAttachments", 
                    "receivedDateTime", "sentDateTime", "from", "sender", 
                    "toRecipients", "ccRecipients", "bccRecipients", "replyTo" };
                requestConfiguration.queryParameters.top = 50;
            });

        while (response != null) {
            final List<Message> messages = response.getValue();
            final String nextLink = response.getOdataNextLink(); // graph response will only have next OR delta link, not both
            final String deltaLink = response.getOdataDeltaLink();

            if (nextLink != null && !nextLink.isBlank()) {
                if (messages != null && !messages.isEmpty()) {
                    applicationEventPublisher.publishEvent(
                        new EmailBatchSyncedEvent(
                            emailProviderMapper.toEmailCreateDtos(messages),
                            userId,
                            null
                            )
                        );
                }
                response = graphClient.me().mailFolders().byMailFolderId("inbox").messages().delta().withUrl(nextLink).get();

            } else if (deltaLink != null && !deltaLink.isBlank()) {
                applicationEventPublisher.publishEvent(
                    new EmailBatchSyncedEvent(
                        emailProviderMapper.toEmailCreateDtos(messages),
                        userId,
                        deltaLink)
                );
            } else {
                throw new IllegalStateException("No next link or delta link found");
            }
        }
    }

    // TODO: think about how to better handle initial vs delta sync
    public void syncEmails(String oboToken, Long userId) {
        GraphServiceClient graphClient = emailClientFactory.getGraphServiceClient(oboToken);

        DeltaGetResponse response =  graphClient.me()
            .mailFolders()
            .byMailFolderId("inbox")
            .messages()
            .delta()
            .get(requestConfiguration -> {
                requestConfiguration.headers.add("Prefer", "outlook.body-content-type=\"text\"");
                requestConfiguration.queryParameters.select = new String[] { 
                    "id", "subject", "body", "conversationId", "hasAttachments", 
                    "receivedDateTime", "sentDateTime", "from", "sender", 
                    "toRecipients", "ccRecipients", "bccRecipients", "replyTo" };
                requestConfiguration.queryParameters.top = 50;
            });

        while (response != null) {
            final List<Message> messages = response.getValue();
            final String nextLink = response.getOdataNextLink(); // graph response will only have next OR delta link, not both
            final String deltaLink = response.getOdataDeltaLink();

            if (nextLink != null && !nextLink.isBlank()) {
                if (messages != null && !messages.isEmpty()) {
                    applicationEventPublisher.publishEvent(
                        new EmailBatchSyncedEvent(
                            emailProviderMapper.toEmailCreateDtos(messages),
                            userId,
                            null
                            )
                        );
                }
                response = graphClient.me().mailFolders().byMailFolderId("inbox").messages().delta().withUrl(nextLink).get();

            } else if (deltaLink != null && !deltaLink.isBlank()) {
                applicationEventPublisher.publishEvent(
                    new EmailBatchSyncedEvent(
                        emailProviderMapper.toEmailCreateDtos(messages),
                        userId,
                        deltaLink)
                );
            } else {
                throw new IllegalStateException("No next link or delta link found");
            }
        }
    }
}