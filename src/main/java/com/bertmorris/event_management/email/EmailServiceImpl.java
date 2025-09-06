package com.bertmorris.event_management.email;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bertmorris.event_management.contact.Contact;
import com.bertmorris.event_management.contact.ContactService;
import com.bertmorris.event_management.contact.dto.ContactInfoDto;
import com.bertmorris.event_management.email.dto.EmailCreateDto;
import com.bertmorris.event_management.email.provider.EmailProvider;
import com.bertmorris.event_management.email.recipient.dto.EmailRecipientCreateDto;
import com.bertmorris.event_management.user.User;
import com.bertmorris.event_management.user.UserService;

@Service
public class EmailServiceImpl implements EmailService {
   
    private final EmailRepository emailRepository;
    private final EmailMapper emailMapper;
    private final EmailProvider emailProvider;
    private final UserService userService;
    private final ContactService contactService;

    public EmailServiceImpl(EmailRepository emailRepository, EmailMapper emailMapper, EmailProvider emailProvider, UserService userService, ContactService contactService) {
        this.emailRepository = emailRepository;
        this.emailMapper = emailMapper;
        this.emailProvider = emailProvider;
        this.userService = userService;
        this.contactService = contactService;
    }

    @Override
    public List<Email> getEmails(String providerId, String oboToken) {
        User user = userService.getOrCreateUser(providerId);

        if (user.getSyncKey() == null) {
            String newSyncKey = batchSync(oboToken);
            user.updateSyncKey(newSyncKey);
        } else {
            String newSyncKey = sync(oboToken, user.getSyncKey());
            user.updateSyncKey(newSyncKey);
        }
        
        return emailRepository.findAll();
    }

    @Override
    public void createEmail(EmailCreateDto emailCreateDto) {
        Map<String, Contact> contactMap = new HashMap<>();
        
        Email email = emailMapper.toEntity(emailCreateDto, contactMap);

        emailRepository.save(email);
    }

    private void sync(String oboToken, String syncKey) {
        Map<String, Contact> contactMap = new HashMap<>();

        String newSyncKey = emailProvider.sync(oboToken, syncKey, dtos -> {
            List<EmailCreateDto> emailCreateDtos = dtos;
            Set<ContactInfoDto> contactInfoDtos = extractContactInfoDtos(emailCreateDtos);
            updateContactCache(contactMap, contactInfoDtos);
            List<Email> emails = emailMapper.toEntities(emailCreateDtos, contactMap);
            emailRepository.saveAll(emails);
        });
    }

    private String batchSync(String oboToken) {
        return "newSyncKey";
    }


    public Set<ContactInfoDto> extractContactInfoDtos(List<EmailCreateDto> emailCreateDtos) {
        Set<ContactInfoDto> contactInfoDtos = new HashSet<>();

        for (EmailCreateDto emailCreateDto : emailCreateDtos) {
            contactInfoDtos.add(emailCreateDto.sender());
            contactInfoDtos.addAll(emailCreateDto.recipients().stream().map(EmailRecipientCreateDto::contactInfo).collect(Collectors.toSet()));
        }

        return contactInfoDtos;
    }

    public void updateContactCache(Map<String, Contact> contactMap, Set<ContactInfoDto> contactInfoDtos) {
        for (ContactInfoDto contactInfoDto : contactInfoDtos) {
            Contact contact = contactMap.get(contactInfoDto.emailAddress());
            if (contact == null) {
                contact = contactService.getOrCreateContact(contactInfoDto.name(), contactInfoDto.emailAddress());
            }

            contactMap.put(contactInfoDto.emailAddress(), contact);
        }
    }

}