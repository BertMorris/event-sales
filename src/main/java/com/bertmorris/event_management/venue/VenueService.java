package com.bertmorris.event_management.venue;

import java.util.List;

import com.bertmorris.event_management.venue.dto.VenueCreateDto;
import com.bertmorris.event_management.venue.dto.VenueUpdateDto;

public interface VenueService {
    
    Venue getVenueById(Long id);

    List<Venue> getVenues();

    Venue createVenue(VenueCreateDto venueCreateDto);

    Venue updateVenue(VenueUpdateDto venueUpdateDto);
    
}
