package com.bertmorris.event_management.lead;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.bertmorris.event_management.lead.dto.LeadCreateDto;
import com.bertmorris.event_management.lead.dto.LeadCreateRequestDto;
import com.bertmorris.event_management.lead.dto.LeadResponseDto;
import com.bertmorris.event_management.lead.dto.LeadUpdateDto;
import com.bertmorris.event_management.lead.dto.LeadUpdateRequestDto;

@Mapper(componentModel = "spring")
public interface LeadMapper {

    @Mapping(target = "owner", source = "ownerId")
    @Mapping(target = "contact", source = "contactId")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Lead toEntity(LeadCreateDto dto);
   
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "owner", source = "ownerId")
    @Mapping(target = "contact", source = "contactId")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Lead updateLeadFromDto(LeadUpdateDto dto, Lead lead);

    @Mapping(source = "owner.id", target = "ownerId")
    @Mapping(source = "contact.id", target = "contactId")
    LeadResponseDto toResponseDto(Lead lead);

    List<LeadResponseDto> toResponseDtos(List<Lead> leads);

    LeadCreateDto toCreateDto(Long userId, LeadCreateRequestDto request);

    LeadUpdateDto toUpdateDto(Long id, LeadUpdateRequestDto request);

}