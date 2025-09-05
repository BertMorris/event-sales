package com.bertmorris.event_management.lead;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bertmorris.event_management.contact.ContactMapper;
import com.bertmorris.event_management.lead.dto.LeadCreateDto;
import com.bertmorris.event_management.lead.dto.LeadCreateRequestDto;
import com.bertmorris.event_management.lead.dto.LeadResponseDto;
import com.bertmorris.event_management.lead.dto.LeadUpdateDto;
import com.bertmorris.event_management.lead.dto.LeadUpdateRequestDto;


@Mapper(componentModel = "spring", uses = { ContactMapper.class })
public interface LeadMapper {

    @Mapping(source = "owner.id", target = "ownerId")
    @Mapping(source = "contact.id", target = "contactId")
    LeadResponseDto toResponseDto(Lead lead);

    List<LeadResponseDto> toResponseDtos(List<Lead> leads);

    @Mapping(source = "ownerId", target = "ownerId")
    LeadCreateDto toCreateDto(Long ownerId, LeadCreateRequestDto request);

    @Mapping(source = "id", target = "id")
    LeadUpdateDto toUpdateDto(Long id, LeadUpdateRequestDto request);

}