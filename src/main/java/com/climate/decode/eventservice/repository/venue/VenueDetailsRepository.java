/**
 * 
 */
package com.climate.decode.eventservice.repository.venue;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.eventservice.entity.venue.VenueDetails;

/**
 * @author diwya
 *
 */
public interface VenueDetailsRepository extends JpaRepository<VenueDetails, Long>  {

	List<VenueDetails> getByEventId(Integer eventId);

	Optional<VenueDetails> getByVenueId(Integer venueId);

	Optional<VenueDetails> getVenueDataByEventIdAndVenueId(Integer eventId, Integer venueId);
	
}
