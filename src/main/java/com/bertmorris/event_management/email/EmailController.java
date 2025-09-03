package com.bertmorris.event_management.email;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bertmorris.event_management.email.dto.EmailResponseDto;
import com.bertmorris.event_management.user.UserService;
import com.microsoft.graph.models.User;


@RestController
@RequestMapping("/emails")
public class EmailController {

    private final UserService userService;
    private final EmailService emailService;
    private final EmailMapper emailMapper;

    public EmailController(UserService userService, EmailService emailService, EmailMapper emailMapper) {
        this.userService = userService;
        this.emailService = emailService;
        this.emailMapper = emailMapper;
    }
    
    @GetMapping
    public ResponseEntity<List<EmailResponseDto>> getEmails(@AuthenticationPrincipal Jwt jwt) {
        String providerId = jwt.getClaimAsString("oid");
        String oboToken = jwt.getTokenValue();


        List<Email> emails = emailService.getEmails(providerId, oboToken);
        List<EmailResponseDto> emailResponseDtos = emailMapper.toResponseDtos(emails);

        return ResponseEntity.ok(emailResponseDtos);
    }
}