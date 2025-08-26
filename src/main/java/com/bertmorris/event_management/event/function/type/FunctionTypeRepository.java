package com.bertmorris.event_management.event.function.type;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FunctionTypeRepository extends JpaRepository<FunctionType, Long> {

    Optional<FunctionType> findByTitle(String title);

}