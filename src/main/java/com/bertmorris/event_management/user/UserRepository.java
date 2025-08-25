package com.bertmorris.event_management.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(String id);

    Optional<User> findByProviderId(String providerId);
}
