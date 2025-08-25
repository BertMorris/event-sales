package com.bertmorris.event_management.lead;

import java.util.List;

public interface LeadMapper {

    // TODO: these probably need some help

    List<LeadResponseDto> entitiesToResponseDtos(List<Lead> leads);

    LeadResponseDto entityToResponseDto(Lead lead);

    LeadCreateDto createRequestDtoToCreateDto(LeadCreateRequestDto request);

}