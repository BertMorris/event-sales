package com.bertmorris.event_management.email;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bertmorris.event_management.contact.Contact;
import com.bertmorris.event_management.contact.dto.ContactInfoDto;
import com.bertmorris.event_management.email.dto.EmailCreateDto;

public interface EmailService {
    
    List<Email> getEmails(String providerId);

    void createEmail(EmailCreateDto emailCreateDto);

    void syncEmails(String providerId, String oboToken);

    Set<ContactInfoDto> extractContactInfoDtos(List<EmailCreateDto> emailCreateDtos);

    void updateContactCache(Map<String, Contact> contactMap, Set<ContactInfoDto> contactInfoDtos);

}