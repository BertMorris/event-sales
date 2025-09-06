package com.bertmorris.event_management.user;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public User getUserByProviderId(String providerId) {
        return userRepository.findByProviderId(providerId).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public User createUser(String providerId) {
        return userRepository.save(new User(providerId));
    }

    @Override
    public User getOrCreateUser(String providerId) {
        return userRepository.findByProviderId(providerId).orElseGet(() -> createUser(providerId));
    }

    @Override
    public String getSyncKey(String providerId) {
        return getUserByProviderId(providerId).getSyncKey();
    }

    @Override
    @Transactional
    public void updateSyncKey(Long userId, String syncKey) {
        User user = getUserById(userId);
        user.setSyncKey(syncKey);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void updateSyncKey(String providerId, String syncKey) {
        User user = getUserByProviderId(providerId);
        user.setSyncKey(syncKey);
        userRepository.save(user);
    }

}