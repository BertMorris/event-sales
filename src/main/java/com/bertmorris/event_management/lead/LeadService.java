package com.bertmorris.event_management.lead;

import java.util.List;

import com.bertmorris.event_management.lead.dto.LeadCreateDto;
import com.bertmorris.event_management.lead.dto.LeadUpdateDto;

public interface LeadService {

    Lead getLead(Long id);

    List<Lead> getLeads();

    Lead createLead(LeadCreateDto leadCreateDto);

    Lead updateLead(LeadUpdateDto leadUpdateDto);

}