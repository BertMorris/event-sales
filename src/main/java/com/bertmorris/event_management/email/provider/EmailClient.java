package com.bertmorris.event_management.email.provider;

import org.springframework.stereotype.Component;

import com.azure.identity.OnBehalfOfCredential;
import com.azure.identity.OnBehalfOfCredentialBuilder;
import com.microsoft.graph.serviceclient.GraphServiceClient;


@Component
public class EmailClient {
   
    private final MsGraphConfig msGraphConfig;

    public EmailClient(MsGraphConfig msGraphConfig) {
        this.msGraphConfig = msGraphConfig;
    }

    public GraphServiceClient getGraphServiceClient(String oboToken) {
        OnBehalfOfCredential credential = new OnBehalfOfCredentialBuilder()
            .clientId(msGraphConfig.clientId())
            .tenantId(msGraphConfig.tenantId())
            .clientSecret(msGraphConfig.clientSecret())
            .userAssertion(oboToken)
            .build();

        if (msGraphConfig.scopes() == null || credential == null) {
            throw new IllegalArgumentException("Scopes and credential cannot be null");
        }

        return new GraphServiceClient(credential, msGraphConfig.scopes());
    }
}