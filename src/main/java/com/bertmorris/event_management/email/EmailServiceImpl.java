package com.bertmorris.event_management.email;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bertmorris.event_management.email.provider.EmailClientFactory;
import com.bertmorris.event_management.email.provider.EmailProvider;
import com.bertmorris.event_management.user.User;
import com.bertmorris.event_management.user.UserService;

@Service
public class EmailServiceImpl implements EmailService {
   
    private final EmailRepository emailRepository;
    private final EmailProvider emailProvider;
    private final UserService userService;

    public EmailServiceImpl(EmailRepository emailRepository, EmailProvider emailProvider, UserService userService) {
        this.emailRepository = emailRepository;
        this.emailProvider = emailProvider;
        this.userService = userService;
    }

    @Override
    public List<Email> getEmails(String providerId, String oboToken) {
        User user = userService.getOrCreateUser(providerId);

        if (user.getSyncKey() == null) {
            String newSyncKey = emailProvider.syncEmails(oboToken);
            userService.updateSyncKey(user, newSyncKey);
        } else {
            String newSyncKey = emailProvider.syncEmails(oboToken, user.getSyncKey());
            userService.updateSyncKey(user, newSyncKey);
        }
        
        return emailRepository.findAll();
    }

}