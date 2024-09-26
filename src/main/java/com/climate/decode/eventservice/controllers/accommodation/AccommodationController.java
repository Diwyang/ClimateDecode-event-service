/**
 * 
 */
package com.climate.decode.eventservice.controllers.accommodation;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.climate.decode.eventservice.api.accommodation.AccommodationApi;
import com.climate.decode.eventservice.dto.accommodation.AccommodationDetailsDto;
import com.climate.decode.eventservice.facade.accommodation.AccommodationFacade;
import com.climate.decode.eventservice.response.ApiResponse;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
public class AccommodationController implements AccommodationApi {

	private final AccommodationFacade accommodationFacade; 
	@Override
	public ApiResponse<AccommodationDetailsDto> createAccommodationDetails(Integer eventId,
			AccommodationDetailsDto accommodationDetailsDto) {
		return ApiResponse.ofSuccess(accommodationFacade.createAccommodationDetails(eventId, accommodationDetailsDto),"Data save successfully");
	}

	@Override
	public ApiResponse<List<AccommodationDetailsDto>> getAccommodationDetailsByEventId(Integer eventId) {
		return ApiResponse.ofSuccess(accommodationFacade.getAccommodationDetailsByEventId(eventId));
	}

	@Override
	public ApiResponse<String> deleteAccommodationDetails(Integer eventId, Integer accommodationId) {
		return ApiResponse.ofSuccess(accommodationFacade.deleteAccommodationDetails(eventId, accommodationId));
	}

	@Override
	public ApiResponse<AccommodationDetailsDto> updateAccommodationDetails(Integer eventId,
			AccommodationDetailsDto accommodationDetailsDto) {
		accommodationDetailsDto.setEventId(eventId);
		return ApiResponse.ofSuccess(accommodationFacade.updateAccommodationDetails(accommodationDetailsDto),"Data Successfully Updated");
	}

	@Override
	public ApiResponse<AccommodationDetailsDto> getAccommodationDetailsByAccommodationId(Integer eventId,
			Integer accommodationId) {
		return ApiResponse.ofSuccess(accommodationFacade.getAccommodationDetailsByEventIdAndAccommodationId(eventId, accommodationId));
	}

}
