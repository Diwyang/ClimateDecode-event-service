/**
 * 
 */
package com.climate.decode.eventservice.facade.accommodation;

import java.util.List;

import com.climate.decode.eventservice.dto.accommodation.AccommodationDetailsDto;

/**
 * @author diwya
 *
 */
public interface AccommodationFacade {

	public AccommodationDetailsDto createAccommodationDetails(Integer eventId, AccommodationDetailsDto accommodationDetailsDto);

	public List<AccommodationDetailsDto> getAccommodationDetailsByEventId(Integer eventId);
	
	public AccommodationDetailsDto getAccommodationDetailsByEventIdAndAccommodationId(Integer eventId, Integer accommodationId);

	public String deleteAccommodationDetails(Integer eventId, Integer accommodationId);

	public AccommodationDetailsDto updateAccommodationDetails(AccommodationDetailsDto accommodationDetailsDto);
}
