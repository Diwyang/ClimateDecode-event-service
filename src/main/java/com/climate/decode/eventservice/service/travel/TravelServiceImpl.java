/**
 * 
 */
package com.climate.decode.eventservice.service.travel;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.eventservice.entity.travel.TravelDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.repository.travel.TravelDetailsRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@RequiredArgsConstructor
@Service
public class TravelServiceImpl implements TravelService {

	private final TravelDetailsRepository repo;
	
	@Override
	public TravelDetails createTravelDetailsData(TravelDetails travelDetail) {
		return repo.save(travelDetail);
	}

	@Override
	public List<TravelDetails> getTravelDetailsDataByEventId(Integer eventId) {
		return repo.getByEventId(eventId);
	}

	@Override
	public Optional<TravelDetails> getTravelDetailsDataByEventIdAndTravelId(Integer eventId, Integer travelID) {
		return repo.getTravelDetailsDataByEventIdAndTravelId(eventId, travelID);
	}

	@Override
	public void deleteTravelDetailsData(Integer eventId, Integer travelId ) {
		if(repo.getTravelDetailsDataByEventIdAndTravelId(eventId, travelId).isPresent()) {
			repo.delete(repo.getTravelDetailsDataByEventIdAndTravelId(eventId, travelId).get());
		}else {
			throw new ResourceNotFoundException("Event not found with ID "+ eventId);
		}
	}

	@Override
	public TravelDetails updateTravelDetailsData(TravelDetails travelDetail) {
		if(repo.getTravelDetailsDataByEventIdAndTravelId(travelDetail.getEventId(), travelDetail.getTravelId()).isPresent()) {
			repo.save(travelDetail);
			return repo.getTravelDetailsDataByEventIdAndTravelId(travelDetail.getEventId(), travelDetail.getTravelId()).get();
		}else {
			throw new ResourceNotFoundException("Event not found with ID "+ travelDetail.getEventId());
		}
	}

}
