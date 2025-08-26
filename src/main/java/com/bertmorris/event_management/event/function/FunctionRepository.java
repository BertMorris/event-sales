package com.bertmorris.event_management.event.function;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FunctionRepository extends JpaRepository<Function, Long> {

    List<Function> findByEventId(Long eventId);

}