package com.bertmorris.event_management.email;

import java.util.List;

import com.bertmorris.event_management.email.dto.EmailCreateDto;

public interface EmailService {
    
    List<Email> getEmails(String providerId, String oboToken);

    void createEmail(EmailCreateDto emailCreateDto);

}