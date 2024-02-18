/**
 * 
 */
package com.climate.decode.eventservice.repository.travel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.eventservice.entity.travel.TravelDetails;

/**
 * @author diwya
 *
 */
public interface TravelDetailsRepository extends JpaRepository<TravelDetails, Long>  {

	List<TravelDetails> getByEventId(Integer eventId);

	Optional<TravelDetails> getByTravelId(Integer travelId);

	Optional<TravelDetails> getTravelDetailsDataByEventIdAndTravelId(Integer eventId, Integer travelId);
	
}
