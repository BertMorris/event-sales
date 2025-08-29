package com.bertmorris.event_management.event;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.bertmorris.event_management.contact.ContactMapper;
import com.bertmorris.event_management.event.dto.EventCreateDto;
import com.bertmorris.event_management.event.dto.EventCreateRequestDto;
import com.bertmorris.event_management.event.dto.EventDetailResponseDto;
import com.bertmorris.event_management.event.dto.EventSummaryResponseDto;
import com.bertmorris.event_management.event.dto.EventUpdateDto;
import com.bertmorris.event_management.event.dto.EventUpdateRequestDto;
import com.bertmorris.event_management.event.function.FunctionMapper;
import com.bertmorris.event_management.event.type.EventTypeMapper;
import com.bertmorris.event_management.lead.LeadMapper;
import com.bertmorris.event_management.user.UserMapper;
import com.bertmorris.event_management.venue.VenueMapper;

@Mapper(componentModel = "spring", uses = { UserMapper.class, ContactMapper.class, LeadMapper.class, EventTypeMapper.class, VenueMapper.class, FunctionMapper.class })
public interface EventMapper {

    EventCreateDto toCreateDto(EventCreateRequestDto dto);

    EventUpdateDto toUpdateDto(Long id, EventUpdateRequestDto dto);

    @Mapping(target = "leadId", source = "lead.id")
    @Mapping(target = "typeId", source = "type.id")
    @Mapping(target = "contactId", source = "contact.id")
    @Mapping(target = "venueId", source = "venue.id")
    EventSummaryResponseDto toSummaryResponseDto(Event event);

    @Mapping(target = "leadId", source = "lead.id")
    @Mapping(target = "typeId", source = "type.id")
    @Mapping(target = "contactId", source = "contact.id")
    @Mapping(target = "venueId", source = "venue.id")
    EventDetailResponseDto toDetailResponseDto(Event event);
   
    @Mapping(target = "owner", source = "ownerId")
    @Mapping(target = "lead", source = "leadId")
    @Mapping(target = "type", source = "typeId")
    @Mapping(target = "contact", source = "contactId")
    @Mapping(target = "venue", source = "venueId")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Event createEntity(EventCreateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "owner", source = "ownerId")
    @Mapping(target = "lead", source = "leadId")
    @Mapping(target = "type", source = "typeId")
    @Mapping(target = "contact", source = "contactId")
    @Mapping(target = "venue", source = "venueId")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Event updateEntity(EventUpdateDto dto, @MappingTarget Event event);

}