package com.bertmorris.event_management.user.util;

import org.springframework.test.util.ReflectionTestUtils;

import com.bertmorris.event_management.user.User;

public class UserTestBuilder {
    
    private Long id;
    private String providerId;
    private String syncKey;
    
    public static UserTestBuilder aUser() {
        return new UserTestBuilder()
            .withId(1L)
            .withProviderId("providerId")
            .withSyncKey("syncKey");
    }

    public User build() {
        User user = new User();
        ReflectionTestUtils.setField(user, "id", this.id);
        user.setProviderId(this.providerId);
        user.setSyncKey(this.syncKey);
        
        return user;
    }

    public UserTestBuilder withId(Long id) {
        this.id = id;
        return this;
    }
    
    public UserTestBuilder withProviderId(String providerId) {
        this.providerId = providerId;
        return this;
    }
    
    public UserTestBuilder withSyncKey(String syncKey) {
        this.syncKey = syncKey;
        return this;
    }
    
}