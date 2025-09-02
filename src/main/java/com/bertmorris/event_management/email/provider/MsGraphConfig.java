package com.bertmorris.event_management.email.provider;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "microsoft")
public record MsGraphConfig(
    String clientId,
    String clientSecret,
    String tenantId,
    String[] scopes
) {
}