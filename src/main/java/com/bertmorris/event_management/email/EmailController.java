package com.bertmorris.event_management.email;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bertmorris.event_management.email.dto.EmailResponseDto;

@RestController
@RequestMapping("/emails")
public class EmailController {

    private final Logger logger = LoggerFactory.getLogger(EmailController.class);

    private final EmailService emailService;
    private final EmailMapper emailMapper;

    public EmailController(EmailService emailService, EmailMapper emailMapper) {
        this.emailService = emailService;
        this.emailMapper = emailMapper;
    }
    
    @GetMapping
    public ResponseEntity<List<EmailResponseDto>> getEmails(@AuthenticationPrincipal Jwt jwt) {
        String providerId = jwt.getClaimAsString("oid");

        // Diagnostics to verify token is correct for OBO
        logger.info("JWT aud: {}", jwt.getAudience());
        logger.info("JWT scp: {}", jwt.getClaimAsString("scp"));
        logger.info("JWT tid: {}", jwt.getClaimAsString("tid"));
        logger.info("JWT azp: {}", jwt.getClaimAsString("azp"));

        emailService.syncEmails(providerId, jwt.getTokenValue());

        
        List<Email> emails = emailService.getEmails(providerId);
        List<EmailResponseDto> emailResponseDtos = emailMapper.toResponseDtos(emails);

        return ResponseEntity.ok(emailResponseDtos);
    }
}