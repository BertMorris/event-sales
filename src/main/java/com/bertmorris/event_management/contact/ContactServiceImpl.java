package com.bertmorris.event_management.contact;

import org.springframework.stereotype.Service;

import com.bertmorris.event_management.contact.dto.ContactCreateDto;
import com.bertmorris.event_management.contact.dto.ContactUpdateDto;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact getById(Long id) {
        return contactRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Contact not found"));
    }

    @Override
    public Contact getByEmailAddress(String emailAddress) {
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

    @Override
    public Contact create(ContactCreateDto contactCreateDto) {
        Contact contact = new Contact();

        contact.setName(contactCreateDto.name());
        contact.setEmailAddress(contactCreateDto.emailAddress());
        if (contactCreateDto.company() != null) {
            contact.setCompany(contactCreateDto.company());
        }

        return contactRepository.save(contact);
    }

    @Override
    public Contact update(ContactUpdateDto contactUpdateDto) {
        Contact contact = getById(contactUpdateDto.id());
        
        if (contactUpdateDto.name() != null) {
            contact.setName(contactUpdateDto.name());
        }
        if (contactUpdateDto.emailAddress() != null) {
            contact.setEmailAddress(contactUpdateDto.emailAddress());
        }
        if (contactUpdateDto.company() != null) {
            contact.setCompany(contactUpdateDto.company());
        }

        return contactRepository.save(contact);
    }

}
