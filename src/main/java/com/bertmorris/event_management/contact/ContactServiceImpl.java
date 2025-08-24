package com.bertmorris.event_management.contact;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Contact not found"));
    }

    @Override
    public Contact getContactByEmailAddress(String emailAddress) {
        return contactRepository.findByEmailAddress(emailAddress).orElseThrow(() -> new EntityNotFoundException("Contact not found"));
    }

    @Override
    public Contact getOrCreateContact(String name, String emailAddress) {
        return contactRepository.findByEmailAddress(emailAddress).orElseGet(() -> contactRepository.save(new Contact(name, emailAddress)));
    }

    @Override
    public Contact getOrCreateContact(String name, String emailAddress, String company) {
        return contactRepository.findByEmailAddress(emailAddress).orElseGet(() -> contactRepository.save(new Contact(name, emailAddress, company)));
    }

}
