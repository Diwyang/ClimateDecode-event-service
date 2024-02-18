/**
 * 
 */
package com.climate.decode.eventservice.service.accommodation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.eventservice.entity.accommodation.AccommodationDetails;
import com.climate.decode.eventservice.entity.information.Information;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.repository.accommodation.AccommodationDetailsRepository;
import com.climate.decode.eventservice.repository.information.EventAttendeesRepository;
import com.climate.decode.eventservice.repository.information.EventVenueRepository;
import com.climate.decode.eventservice.repository.information.InformationRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@RequiredArgsConstructor
@Service
public class AccommodationServiceImpl implements AccommodationService {

	private final AccommodationDetailsRepository repo;
	
	@Override
	public AccommodationDetails createAccommodationData(AccommodationDetails accommodation) {
		return repo.save(accommodation);
	}

	@Override
	public List<AccommodationDetails> getAccommodationDataByEventId(Integer eventId) {
		return repo.getByEventId(eventId);
	}

	@Override
	public Optional<AccommodationDetails> getAccommodationDataByEventId(Integer eventId, Integer accommodationId) {
		return repo.getAccommodationDataByEventIdAndAccommodationId(eventId, accommodationId);
	}

	@Override
	public void deleteAccommodationData(Integer eventId, Integer accommodationId ) {
		if(repo.getAccommodationDataByEventIdAndAccommodationId(eventId, accommodationId).isPresent()) {
			repo.delete(repo.getAccommodationDataByEventIdAndAccommodationId(eventId, accommodationId).get());
		}else {
			throw new ResourceNotFoundException("Event not found with ID "+ eventId);
		}
	}

	@Override
	public AccommodationDetails updateAccommodationData(AccommodationDetails accommodation) {
		if(repo.getAccommodationDataByEventIdAndAccommodationId(accommodation.getEventId(), accommodation.getAccommodationId()).isPresent()) {
			repo.save(accommodation);
			return repo.getAccommodationDataByEventIdAndAccommodationId(accommodation.getEventId(), accommodation.getAccommodationId()).get();
		}else {
			throw new ResourceNotFoundException(String.format("Accomdation not found For Event ID  {} and Accomdation ID {}", accommodation.getEventId(),accommodation.getAccommodationId()));
		}
	}

}
