/**
 * 
 */
package com.climate.decode.eventservice.service.travel;

import java.util.List;
import java.util.Optional;

import com.climate.decode.eventservice.entity.travel.TravelDetails;

/**
 * @author diwya
 *
 */
public interface TravelService {

	public TravelDetails createTravelDetailsData(TravelDetails	 travelDetail);

	public List<TravelDetails> getTravelDetailsDataByEventId(Integer eventId);
	
	public Optional<TravelDetails> getTravelDetailsDataByEventIdAndTravelId(Integer eventId, Integer travelId);

	public void deleteTravelDetailsData(Integer eventId, Integer travelId);

	public TravelDetails updateTravelDetailsData(TravelDetails travelDetail);
}
