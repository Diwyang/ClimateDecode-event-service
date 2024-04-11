package com.climate.decode.eventservice.api.venue;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.climate.decode.eventservice.dto.venue.VenueDetailsDto;
import com.climate.decode.eventservice.response.ApiResponse;

@RequestMapping("/events/{eventId}/venue-details")
public interface VenueDetailsApi {

	@PostMapping("")
	public ApiResponse<VenueDetailsDto> createVenueDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody VenueDetailsDto venueDetailsDto);
	
	@GetMapping("")
	public ApiResponse<List<VenueDetailsDto>> getVenueDetailsByEventId(@PathVariable(value = "eventId") Integer eventId, @RequestParam(name = "filterEnergyType", required = false, defaultValue = " ")String filterEnergyTypeValue);
	
	@GetMapping("/{venueId}")
	public ApiResponse<VenueDetailsDto> getVenueDetailsByVenueId(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "venueId") Integer venueId);

	
	@DeleteMapping("/{venueId}")
	public ApiResponse<String> deleteVenueDetails(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "venueId") Integer venueId);
	
	@PatchMapping("")
	public ApiResponse<VenueDetailsDto> updateVenueDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody VenueDetailsDto venueDetailsDto);
	
}
