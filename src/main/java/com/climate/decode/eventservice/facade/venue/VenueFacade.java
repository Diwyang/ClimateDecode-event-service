/**
 * 
 */
package com.climate.decode.eventservice.facade.venue;

import java.util.List;

import com.climate.decode.eventservice.dto.venue.VenueDetailsDto;


/**
 * @author diwya
 *
 */
public interface VenueFacade {

	public VenueDetailsDto createVenueDetails(Integer eventId, VenueDetailsDto venueDetailsDto);

	public List<VenueDetailsDto> getVenueDetailsByEventId(Integer eventId);
	
	public VenueDetailsDto getVenueDetailsByEventIdAndVenueId(Integer eventId, Integer venueId);

	public String deleteVenueDetails(Integer eventId, Integer venueId);

	public VenueDetailsDto updateVenueDetails(VenueDetailsDto venueDetailsDto);
}
