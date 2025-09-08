package com.bertmorris.event_management.email.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.azure.identity.OnBehalfOfCredential;
import com.azure.identity.OnBehalfOfCredentialBuilder;
import com.microsoft.graph.serviceclient.GraphServiceClient;


@Component
public class EmailClientFactory {
   
    private final Logger logger = LoggerFactory.getLogger(EmailClientFactory.class);
    
    private final MsGraphConfig msGraphConfig;

    public EmailClientFactory(MsGraphConfig msGraphConfig) {
        this.msGraphConfig = msGraphConfig;
    }

    public GraphServiceClient getGraphServiceClient(String oboToken) {

        logger.info("Scopes: {}", msGraphConfig.scopes());
        logger.info("Client secret: {}", msGraphConfig.clientSecret());

        try {
            OnBehalfOfCredential credential = new OnBehalfOfCredentialBuilder()
                .clientId(msGraphConfig.clientId())
                .tenantId("common")
                .clientSecret(msGraphConfig.clientSecret())
                .userAssertion(oboToken)
                .build();

            if (msGraphConfig.scopes() == null || credential == null) {
                throw new IllegalArgumentException("Scopes and credential cannot be null");
            }
    
            return new GraphServiceClient(credential, msGraphConfig.scopes());
        } catch (Exception e) {
            logger.error("Error creating GraphServiceClient", e);
            throw new RuntimeException("Error creating GraphServiceClient", e);
        }
    
    }
}