package com.climate.decode.eventservice.api.eventpreparation;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.climate.decode.eventservice.dto.eventpreparation.EventPreparationDetailsDto;
import com.climate.decode.eventservice.response.ApiResponse;

@RequestMapping("/events/{eventId}/eventPreparation-details")
public interface EventPreparationDetailsApi {

	@PostMapping("")
	public ApiResponse<EventPreparationDetailsDto> createEventPreparationDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody EventPreparationDetailsDto eventPreparationDetailsDto);
	
	@GetMapping("")
	public ApiResponse<List<EventPreparationDetailsDto>> getEventPreparationDetailsByEventId(@PathVariable(value = "eventId") Integer eventId);
	
	@GetMapping("/{eventPreparationId}")
	public ApiResponse<EventPreparationDetailsDto> getEventPreparationDetailsByEventPreparationId(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "eventPreparationId") Integer eventPreparationId);

	
	@DeleteMapping("/{eventPreparationId}")
	public ApiResponse<String> deleteEventPreparationDetails(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "eventPreparationId") Integer eventPreparationId);
	
	@PatchMapping("")
	public ApiResponse<EventPreparationDetailsDto> updateEventPreparationDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody EventPreparationDetailsDto eventPreparationDetailsDto);
	
}
