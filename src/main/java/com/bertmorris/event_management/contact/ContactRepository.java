package com.bertmorris.event_management.contact;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Optional<Contact> findByEmailAddress(String emailAddress);

}