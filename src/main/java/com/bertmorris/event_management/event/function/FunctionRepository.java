package com.bertmorris.event_management.events.function;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FunctionRepository extends JpaRepository<Function, Long> {

    Optional<Function> findByFunctionId(Long functionId);

    Optional<Function> findByTitle(String title);

}
