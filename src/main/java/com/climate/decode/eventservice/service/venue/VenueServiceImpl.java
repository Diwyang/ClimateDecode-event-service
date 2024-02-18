package com.climate.decode.eventservice.service.venue;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.eventservice.entity.venue.VenueDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.repository.venue.VenueDetailsRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VenueServiceImpl implements VenueService {


	private final VenueDetailsRepository repo;
	
	@Override
	public VenueDetails createVenueData(VenueDetails venue) {
		return repo.save(venue);
	}

	@Override
	public List<VenueDetails> getVenueDataByEventId(Integer eventId) {
		return repo.getByEventId(eventId);
	}

	@Override
	public Optional<VenueDetails> getVenueDataByEventId(Integer eventId, Integer venueId) {
		return repo.getVenueDataByEventIdAndVenueId(eventId, venueId);
	}

	@Override
	public void deleteVenueData(Integer eventId, Integer venueId) {
		if(repo.getVenueDataByEventIdAndVenueId(eventId, venueId).isPresent()) {
			repo.delete(repo.getVenueDataByEventIdAndVenueId(eventId, venueId).get());
		}else {
			throw new ResourceNotFoundException("Event not found with ID "+ eventId);
		}

	}

	@Override
	public VenueDetails updateVenueData(VenueDetails venue) {
		if(repo.getVenueDataByEventIdAndVenueId(venue.getEventId(), venue.getVenueId()).isPresent()) {
			repo.save(venue);
			return repo.getVenueDataByEventIdAndVenueId(venue.getEventId(), venue.getVenueId()).get();
		}else {
			throw new ResourceNotFoundException(String.format("Venue not found For Event ID  {} and Venue ID {}", venue.getEventId(),venue.getVenueId()));
		}
	}

}
