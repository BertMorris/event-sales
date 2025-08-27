package com.bertmorris.event_management.lead;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.InjectionStrategy;

import com.bertmorris.event_management.contact.ContactMapper;
import com.bertmorris.event_management.lead.dto.LeadCreateDto;
import com.bertmorris.event_management.lead.dto.LeadCreateRequestDto;
import com.bertmorris.event_management.lead.dto.LeadResponseDto;
import com.bertmorris.event_management.lead.dto.LeadUpdateDto;
import com.bertmorris.event_management.lead.dto.LeadUpdateRequestDto;
import com.bertmorris.event_management.user.UserMapper;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = { UserMapper.class, ContactMapper.class })
public interface LeadMapper {

    @Mapping(target = "owner", source = "ownerId")
    @Mapping(target = "contact", source = "contactId")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Lead toEntity(LeadCreateDto dto);
   
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "owner", source = "dto.ownerId")
    @Mapping(target = "contact", source = "dto.contactId")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateLeadFromDto(LeadUpdateDto dto, @MappingTarget Lead lead);

    @Mapping(source = "owner.id", target = "ownerId")
    @Mapping(source = "contact.id", target = "contactId")
    LeadResponseDto toResponseDto(Lead lead);

    List<LeadResponseDto> toResponseDtos(List<Lead> leads);

    LeadCreateDto toCreateDto(Long ownerId, LeadCreateRequestDto request);

    LeadUpdateDto toUpdateDto(Long id, LeadUpdateRequestDto request);

}