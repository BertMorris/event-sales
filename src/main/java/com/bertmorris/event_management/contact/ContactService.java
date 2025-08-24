package com.bertmorris.event_management.contact;


public interface ContactService {

    Contact getContactById(Long id);

    Contact getContactByEmailAddress(String emailAddress);

    Contact getOrCreateContact(String name, String emailAddress);

    Contact getOrCreateContact(String name, String emailAddress, String company);

}
