package com.bertmorris.event_management.email.provider;

import java.util.List;

import org.springframework.stereotype.Component;

import com.microsoft.graph.users.item.mailfolders.item.messages.delta.DeltaGetResponse;
import com.bertmorris.event_management.email.EmailService;
import com.bertmorris.event_management.email.dto.EmailCreateDto;
import com.microsoft.graph.models.Message;
import com.microsoft.graph.serviceclient.GraphServiceClient;

@Component
public class EmailProvider {

    private final EmailClientFactory emailClientFactory;
    private final EmailProviderMapper emailProviderMapper;
    private final EmailService emailService;
    
    public EmailProvider(EmailClientFactory emailClientFactory, EmailProviderMapper emailProviderMapper, EmailService emailService) {
        this.emailClientFactory = emailClientFactory;
        this.emailProviderMapper = emailProviderMapper;
        this.emailService = emailService;
    }
    
    public String syncEmails(String oboToken, String syncKey) {
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

        while (response.getValue() != null) {
            final List<Message> messages = response.getValue();
            for (Message message : messages) {
                EmailCreateDto emailCreateDto = emailProviderMapper.toEmailCreateDto(message);
                emailService.createEmail(emailCreateDto);
            }
       
            final String nextLink = response.getOdataNextLink();
            if (nextLink == null || nextLink.isBlank()) {
                break;
            } else {
                response = graphClient.me().mailFolders().byMailFolderId("inbox").messages().delta().withUrl(nextLink).get();
            }
        }
        
        return response.getOdataDeltaLink();
    }

    public String syncEmails(String oboToken) {
        GraphServiceClient graphServiceClient = emailClientFactory.getGraphServiceClient(oboToken);
        

        return "syncKey";
    }


}
