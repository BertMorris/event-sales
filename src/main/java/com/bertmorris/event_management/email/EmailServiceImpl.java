package com.bertmorris.event_management.email;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
   
    private final EmailRepository emailRepository;

    public EmailServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public List<Email> getEmails() {
        return emailRepository.findAll();
    }

}