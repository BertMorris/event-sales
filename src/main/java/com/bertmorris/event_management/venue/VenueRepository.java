package com.bertmorris.event_management.events.venue;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
    
    Optional<Venue> findByVenueId(Long venueId);

    Optional<Venue> findByName(String name);

}
