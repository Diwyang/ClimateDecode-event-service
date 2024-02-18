/**
 * 
 */
package com.climate.decode.eventservice.repository.accommodation;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.eventservice.entity.accommodation.AccommodationDetails;

/**
 * @author diwya
 *
 */
public interface AccommodationDetailsRepository extends JpaRepository<AccommodationDetails, Long>  {

	List<AccommodationDetails> getByEventId(Integer eventId);

	Optional<AccommodationDetails> getByAccommodationId(Integer accommodationId);

	Optional<AccommodationDetails> getAccommodationDataByEventIdAndAccommodationId(Integer eventId, Integer accommodationId);
	
}
