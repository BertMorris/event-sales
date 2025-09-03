package com.bertmorris.event_management.email;

public class EmailServiceImpl implements EmailService {
    
    @Override
    public List<Email> getEmails() {
        return emailRepository.findAll();
    }

}
