/**
 * 
 */
package com.climate.decode.eventservice.service.venue;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.climate.decode.eventservice.entity.venue.VenueDetails;

/**
 * @author diwya
 *
 */
public interface VenueService {

	public VenueDetails createVenueData(@RequestBody VenueDetails venue);

	public List<VenueDetails> getVenueDataByEventId(Integer eventId);
	
	public Optional<VenueDetails> getVenueDataByEventId(Integer eventId, Integer venueId);

	public void deleteVenueData(Integer eventId, Integer venueId);

	public VenueDetails updateVenueData(VenueDetails venue);
}
