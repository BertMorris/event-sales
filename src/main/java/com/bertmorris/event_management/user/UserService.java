package com.bertmorris.event_management.user;

public interface UserService {
    
    User getUserById(Long id);

    User getUserByProviderId(String providerId);

    User createUser(String providerId);

    User getOrCreateUser(String providerId);

    String getSyncKey(String providerId);

    void updateSyncKey(Long userId, String syncKey);

    void updateSyncKey(String providerId, String syncKey);

}