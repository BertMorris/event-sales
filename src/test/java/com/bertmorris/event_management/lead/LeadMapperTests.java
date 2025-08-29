package com.bertmorris.event_management.lead;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bertmorris.event_management.contact.ContactMapperImpl;
import com.bertmorris.event_management.lead.dto.LeadCreateDto;
import com.bertmorris.event_management.user.UserMapperImpl;

@ExtendWith(SpringExtension.class)
@Import({LeadMapperImpl.class,
    UserMapperImpl.class,
    ContactMapperImpl.class
})
public class LeadMapperTests {

    @Autowired
    private LeadMapper leadMapper;

}
