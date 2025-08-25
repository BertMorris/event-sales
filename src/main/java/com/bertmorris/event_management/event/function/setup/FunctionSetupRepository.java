package com.bertmorris.event_management.event.function.setup;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FunctionSetupRepository extends JpaRepository<FunctionSetup, Long> {

    Optional<FunctionSetup> findByFunctionSetupId(Long functionSetupId);

    Optional<FunctionSetup> findByTitle(String title);

}
