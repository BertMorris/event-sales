package com.bertmorris.event_management.venue;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bertmorris.event_management.venue.dto.VenueCreateDto;
import com.bertmorris.event_management.venue.dto.VenueUpdateDto;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VenueServiceImpl implements VenueService {
    
    private final VenueRepository venueRepository;

    public VenueServiceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public Venue getVenueById(Long id) {
        return venueRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Venue not found"));
    }

    @Override
    public List<Venue> getVenues() {
        return venueRepository.findAll();
    }

    @Override
    public Venue createVenue(VenueCreateDto venueCreateDto) {
        Venue venue = new Venue(venueCreateDto.name(), venueCreateDto.capacity());

        return venueRepository.save(venue);
    }

    @Override
    public Venue updateVenue(VenueUpdateDto venueUpdateDto) {
        Venue venue = getVenueById(venueUpdateDto.id());

        if (venueUpdateDto.name() != null) {
            venue.setName(venueUpdateDto.name());
        }
        if (venueUpdateDto.capacity() != null) {
            venue.setCapacity(venueUpdateDto.capacity());
        }

        return venueRepository.save(venue);
    }
}
