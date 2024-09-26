/**
 * 
 */
package com.climate.decode.eventservice.controllers.venue;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.climate.decode.eventservice.api.venue.VenueDetailsApi;
import com.climate.decode.eventservice.dto.venue.VenueDetailsDto;
import com.climate.decode.eventservice.facade.venue.VenueFacade;
import com.climate.decode.eventservice.response.ApiResponse;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
public class VenueController implements VenueDetailsApi {

	private final VenueFacade venueFacade;

	@Override
	public ApiResponse<VenueDetailsDto> createVenueDetails(Integer eventId, VenueDetailsDto venueDetailsDto) {
		return ApiResponse.ofSuccess(venueFacade.createVenueDetails(eventId, venueDetailsDto),
				"Data save successfully");
	}

	@Override
	public ApiResponse<List<VenueDetailsDto>> getVenueDetailsByEventId(Integer eventId, String filterEnergyTypeValue) {
		return ApiResponse.ofSuccess(venueFacade.getVenueDetailsByEventId(eventId, filterEnergyTypeValue));
	}

	@Override
	public ApiResponse<String> deleteVenueDetails(Integer eventId, Integer venueId) {
		return ApiResponse.ofSuccess(venueFacade.deleteVenueDetails(eventId, venueId));
	}

	@Override
	public ApiResponse<VenueDetailsDto> updateVenueDetails(Integer eventId, VenueDetailsDto venueDetailsDto) {
		venueDetailsDto.setEventId(eventId);
		return ApiResponse.ofSuccess(venueFacade.updateVenueDetails(venueDetailsDto), "Data Successfully Updated");
	}

	@Override
	public ApiResponse<VenueDetailsDto> getVenueDetailsByVenueId(Integer eventId, Integer venueId) {
		return ApiResponse.ofSuccess(venueFacade.getVenueDetailsByEventIdAndVenueId(eventId, venueId));
	}

}
