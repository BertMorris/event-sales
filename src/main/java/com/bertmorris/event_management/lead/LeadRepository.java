package com.bertmorris.event_management.lead;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadRepository extends JpaRepository<Lead, Long> {

    List<Lead> findByOwnerId(Long ownerId);

}
