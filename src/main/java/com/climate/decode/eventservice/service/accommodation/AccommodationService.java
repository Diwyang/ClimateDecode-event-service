/**
 * 
 */
package com.climate.decode.eventservice.service.accommodation;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.climate.decode.eventservice.entity.accommodation.AccommodationDetails;

/**
 * @author diwya
 *
 */
public interface AccommodationService {

	public AccommodationDetails createAccommodationData(@RequestBody AccommodationDetails	 accommodation);

	public List<AccommodationDetails> getAccommodationDataByEventId(Integer eventId);
	
	public Optional<AccommodationDetails> getAccommodationDataByEventId(Integer eventId, Integer accommodationId);

	public void deleteAccommodationData(Integer eventId, Integer accommodationId);

	public AccommodationDetails updateAccommodationData(AccommodationDetails accommodation);
}
