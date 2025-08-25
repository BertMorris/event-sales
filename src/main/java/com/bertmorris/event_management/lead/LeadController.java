package com.bertmorris.event_management.lead;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bertmorris.event_management.lead.dto.LeadCreateDto;
import com.bertmorris.event_management.lead.dto.LeadCreateRequestDto;
import com.bertmorris.event_management.lead.dto.LeadResponseDto;
import com.bertmorris.event_management.lead.dto.LeadUpdateDto;
import com.bertmorris.event_management.lead.dto.LeadUpdateRequestDto;
import com.bertmorris.event_management.user.User;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/leads")
public class LeadController {

    private final LeadService leadService;
    private final LeadMapper leadMapper;
    
    public LeadController(LeadService leadService, LeadMapper leadMapper) {
        this.leadService = leadService;
        this.leadMapper = leadMapper;
    }

    @GetMapping
    public ResponseEntity<List<LeadResponseDto>> getLeads() {
        List<Lead> leads = leadService.getLeads();
        List<LeadResponseDto> leadResponseDtos = leadMapper.toResponseDtos(leads);

        return ResponseEntity.ok(leadResponseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeadResponseDto> getLead(@PathVariable Long id) {
        Lead lead = leadService.getLead(id);
        LeadResponseDto leadResponseDto = leadMapper.toResponseDto(lead);

        return ResponseEntity.ok(leadResponseDto);
    }

    @PostMapping
    public ResponseEntity<LeadResponseDto> createLead(@RequestBody @Valid LeadCreateRequestDto request) {
        User user = new User(); // TODO: get user from jwt

        LeadCreateDto leadCreateDto = leadMapper.toCreateDto(user.getId(), request);
        Lead newLead = leadService.createLead(leadCreateDto);
        LeadResponseDto leadResponseDto = leadMapper.toResponseDto(newLead);
        
        return ResponseEntity.ok(leadResponseDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LeadResponseDto> updateLead(@PathVariable Long id, @RequestBody @Valid LeadUpdateRequestDto request) {
        LeadUpdateDto leadUpdateDto = leadMapper.toUpdateDto(id, request);
        Lead updatedLead = leadService.updateLead(leadUpdateDto);
        LeadResponseDto leadResponseDto = leadMapper.toResponseDto(updatedLead);

        return ResponseEntity.ok(leadResponseDto);
    }
    
}