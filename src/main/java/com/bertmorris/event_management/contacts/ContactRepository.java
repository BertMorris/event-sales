package com.bertmorris.event_management.contacts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Optional<Contact> findByContactId(Long contactId);

    Optional<Contact> findByEmailAddress(String emailAddress);

}
