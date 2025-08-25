package com.bertmorris.event_management.lead;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bertmorris.event_management.lead.dto.LeadCreateDto;
import com.bertmorris.event_management.lead.dto.LeadUpdateDto;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LeadServiceImpl implements LeadService {

    private final LeadRepository leadRepository;
    private final LeadMapper leadMapper;

    public LeadServiceImpl(LeadRepository leadRepository, LeadMapper leadMapper) {
        this.leadRepository = leadRepository;
        this.leadMapper = leadMapper;
    }

    @Override
    public Lead getLead(Long id) {
        return leadRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Lead not found"));
    }

    @Override
    public List<Lead> getLeads() {
        return leadRepository.findAll();
    }
    
    @Override
    public Lead createLead(LeadCreateDto leadCreateDto) {
        Lead lead = leadMapper.toEntity(leadCreateDto);

        return leadRepository.save(lead);
    }

    @Override
    public Lead updateLead(LeadUpdateDto leadUpdateDto) {
        Long id = leadUpdateDto.id();
        Lead lead = getLead(id);
        Lead updatedLead = leadMapper.updateLeadFromDto(leadUpdateDto, lead);

        return leadRepository.save(updatedLead);
    }
}