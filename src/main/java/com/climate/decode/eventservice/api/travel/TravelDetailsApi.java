package com.climate.decode.eventservice.api.travel;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.climate.decode.eventservice.dto.travel.TravelDetailsDto;
import com.climate.decode.eventservice.response.ApiResponse;

@RequestMapping("/events/{eventId}/travel-details")
public interface TravelDetailsApi {

	@PostMapping("")
	public ApiResponse<TravelDetailsDto> createTravelDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody TravelDetailsDto travelDetailsDto);
	
	@GetMapping("")
	public ApiResponse<List<TravelDetailsDto>> getTravelDetailsByEventId(@PathVariable(value = "eventId") Integer eventId);
	
	@GetMapping("/{travelId}")
	public ApiResponse<TravelDetailsDto> getTravelDetailsByTravelId(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "travelId") Integer travelId);

	
	@DeleteMapping("/{travelId}")
	public ApiResponse<String> deleteTravelDetails(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "travelId") Integer travelId);
	
	@PatchMapping("")
	public ApiResponse<TravelDetailsDto> updateTravelDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody TravelDetailsDto travelDetailsDto);
}
