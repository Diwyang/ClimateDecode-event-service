package com.climate.decode.eventservice.api.accommodation;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.climate.decode.eventservice.dto.accommodation.AccommodationDetailsDto;
import com.climate.decode.eventservice.response.ApiResponse;

@RequestMapping("/events/{eventId}/accommodation-details")
public interface AccommodationApi {

	@PostMapping("")
	public ApiResponse<AccommodationDetailsDto> createAccommodationDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody AccommodationDetailsDto accommodationDetailsDto);
	
	@GetMapping("")
	public ApiResponse<List<AccommodationDetailsDto>> getAccommodationDetailsByEventId(@PathVariable(value = "eventId") Integer eventId);
	
	@GetMapping("/{accommodationId}")
	public ApiResponse<AccommodationDetailsDto> getAccommodationDetailsByAccommodationId(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "accommodationId") Integer accommodationId);

	
	@DeleteMapping("/{accommodationId}")
	public ApiResponse<String> deleteAccommodationDetails(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "accommodationId") Integer accommodationId);
	
	@PatchMapping("")
	public ApiResponse<AccommodationDetailsDto> updateAccommodationDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody AccommodationDetailsDto accommodationDetailsDto);
}
