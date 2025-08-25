package com.bertmorris.event_management.lead;

import java.util.List;

public interface LeadService {

    List<Lead> getLeads();

    Lead getLeadById(Long id);

    Lead createLead(LeadCreateDto leadCreateDto);

}
