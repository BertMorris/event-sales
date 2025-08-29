package com.bertmorris.event_management.contact;

import com.bertmorris.event_management.contact.dto.ContactCreateDto;
import com.bertmorris.event_management.contact.dto.ContactUpdateDto;

public interface ContactService {

    Contact getById(Long id);

    Contact getByEmailAddress(String emailAddress);

    Contact create(ContactCreateDto contactCreateDto);

    Contact update(ContactUpdateDto contactUpdateDto);

    Contact getOrCreateContact(String name, String emailAddress);

    Contact getOrCreateContact(String name, String emailAddress, String company);

}
