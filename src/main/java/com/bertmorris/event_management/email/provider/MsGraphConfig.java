package com.bertmorris.event_management.email.provider;

import org.springframework.boot.context.properties.ConfigurationProperties;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@ConfigurationProperties(prefix = "microsoft")
public record MsGraphConfig(
    @NotBlank
    String clientId,
    @NotBlank
    String clientSecret,
    @NotBlank
    String tenantId,
    @NotEmpty
    String[] scopes
) {
}