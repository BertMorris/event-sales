package com.bertmorris.event_management.email;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bertmorris.event_management.email.dto.EmailCreateDto;
import com.bertmorris.event_management.email.provider.EmailClientFactory;
import com.bertmorris.event_management.email.provider.EmailProvider;
import com.bertmorris.event_management.user.User;
import com.bertmorris.event_management.user.UserService;

@Service
public class EmailServiceImpl implements EmailService {
   
    private final EmailRepository emailRepository;
    private final EmailMapper emailMapper;
    private final EmailProvider emailProvider;
    private final UserService userService;

    public EmailServiceImpl(EmailRepository emailRepository, EmailMapper emailMapper, EmailProvider emailProvider, UserService userService) {
        this.emailRepository = emailRepository;
        this.emailMapper = emailMapper;
        this.emailProvider = emailProvider;
        this.userService = userService;
    }

    @Override
    public List<Email> getEmails(String providerId, String oboToken) {
        User user = userService.getOrCreateUser(providerId);

        if (user.getSyncKey() == null) {
            String newSyncKey = emailProvider.syncEmails(oboToken);
            user.updateSyncKey(newSyncKey);
        } else {
            String newSyncKey = emailProvider.syncEmails(oboToken, user.getSyncKey());
            user.updateSyncKey(newSyncKey);
        }
        
        return emailRepository.findAll();
    }

    @Override
    public void createEmail(EmailCreateDto emailCreateDto) {
        Email email = emailMapper.toEntity(emailCreateDto);

        emailRepository.save(email);
    }

}