/**
 * 
 */
package com.climate.decode.eventservice.controllers.travel;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.climate.decode.eventservice.api.travel.TravelDetailsApi;
import com.climate.decode.eventservice.dto.travel.TravelDetailsDto;
import com.climate.decode.eventservice.facade.travel.TravelDetailsFacade;
import com.climate.decode.eventservice.response.ApiResponse;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
public class TravelDetailsController implements TravelDetailsApi {

	private final TravelDetailsFacade travelDetailsFacade; 
	@Override
	public ApiResponse<TravelDetailsDto> createTravelDetails(Integer eventId,
			TravelDetailsDto travelDetailsDto) {
		return ApiResponse.ofSuccess(travelDetailsFacade.createTravelDetails(eventId, travelDetailsDto),"Data save successfully");
	}

	@Override
	public ApiResponse<List<TravelDetailsDto>> getTravelDetailsByEventId(Integer eventId) {
		return ApiResponse.ofSuccess(travelDetailsFacade.getTravelDetailsByEventId(eventId));
	}

	@Override
	public ApiResponse<String> deleteTravelDetails(Integer eventId, Integer accommodationId) {
		return ApiResponse.ofSuccess(travelDetailsFacade.deleteTravelDetails(eventId, accommodationId));
	}

	@Override
	public ApiResponse<TravelDetailsDto> updateTravelDetails(Integer eventId,
			TravelDetailsDto travelDetailsDto) {
		travelDetailsDto.setEventId(eventId);
		return ApiResponse.ofSuccess(travelDetailsFacade.updateTravelDetails(travelDetailsDto),"Data Successfully Updated");
	}

	@Override
	public ApiResponse<TravelDetailsDto> getTravelDetailsByTravelId(Integer eventId,
			Integer travelId) {
		return ApiResponse.ofSuccess(travelDetailsFacade.getTravelDetailsByEventIdAndTravelId(eventId, travelId));
	}

}
