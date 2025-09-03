package com.bertmorris.event_management.email;

import java.util.List;

public interface EmailService {
    
    List<Email> getEmails(String providerId, String oboToken);

}