package com.bertmorris.event_management.lead;

import java.util.List;

import org.springframework.stereotype.Service;

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
    public List<Lead> getLeads() {
        return leadRepository.findAll();
    }

    @Override
    public Lead getLeadById(Long id) {
        return leadRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Lead not found"));
    }

    @Override
    public Lead createLead(LeadCreateDto leadCreateDto) {
        Lead lead = leadMapper.createDtoToEntity(leadCreateDto);

        return leadRepository.save(lead);
    }
}
