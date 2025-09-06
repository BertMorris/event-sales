package com.bertmorris.event_management.email;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.bertmorris.event_management.contact.Contact;
import com.bertmorris.event_management.contact.dto.ContactInfoDto;
import com.bertmorris.event_management.email.provider.EmailBatchSyncedEvent;
import com.bertmorris.event_management.user.UserService;

import jakarta.transaction.Transactional;

@Component
public class EmailSyncListener {
   
    private final EmailService emailService;
    private final EmailRepository emailRepository;
    private final EmailMapper emailMapper;
    private final UserService userService;

    public EmailSyncListener(EmailService emailService, EmailRepository emailRepository, EmailMapper emailMapper, UserService userService) {
        this.emailService = emailService;
        this.emailRepository = emailRepository;
        this.emailMapper = emailMapper;
        this.userService = userService;
    }

    @EventListener
    @Transactional
    public void onEmailBatchSynced(EmailBatchSyncedEvent event) {
        if (event.emailCreateDtos() != null && !event.emailCreateDtos().isEmpty()) {
            Map<String, Contact> contactMap = new HashMap<>();
            Set<ContactInfoDto> contactInfoDtos = emailService.extractContactInfoDtos(event.emailCreateDtos());
            emailService.updateContactCache(contactMap, contactInfoDtos);
            List<Email> emails = emailMapper.toEntities(event.emailCreateDtos(), contactMap);
            emailRepository.saveAll(emails);
        }
        if (event.syncKey() != null && !event.syncKey().isBlank()) {
            userService.updateSyncKey(event.userId(), event.syncKey());
        }
    }
}
