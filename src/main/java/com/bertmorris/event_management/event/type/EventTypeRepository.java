package com.bertmorris.event_management.event.type;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepository extends JpaRepository<EventType, Long> {

    Optional<EventType> findByName(String name);

}
