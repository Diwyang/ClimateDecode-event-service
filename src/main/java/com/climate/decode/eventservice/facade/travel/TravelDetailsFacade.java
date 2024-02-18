/**
 * 
 */
package com.climate.decode.eventservice.facade.travel;

import java.util.List;

import com.climate.decode.eventservice.dto.travel.TravelDetailsDto;

/**
 * @author diwya
 *
 */
public interface TravelDetailsFacade {

	public TravelDetailsDto createTravelDetails(Integer eventId, TravelDetailsDto travelDetailsDto);

	public List<TravelDetailsDto> getTravelDetailsByEventId(Integer eventId);
	
	public TravelDetailsDto getTravelDetailsByEventIdAndTravelId(Integer eventId, Integer travelId);

	public String deleteTravelDetails(Integer eventId, Integer travelId);

	public TravelDetailsDto updateTravelDetails(TravelDetailsDto travelDetailsDto);
}
