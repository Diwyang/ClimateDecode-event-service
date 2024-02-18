package com.climate.decode.eventservice.api.information;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.climate.decode.eventservice.dto.information.EventAttendeeDetailsDto;
import com.climate.decode.eventservice.dto.information.EventVenueDetailsDto;
import com.climate.decode.eventservice.dto.information.InformationDto;
import com.climate.decode.eventservice.response.ApiResponse;

@RequestMapping("/events/information")
public interface InformationApi {
	
	@PostMapping("")
	public ApiResponse<InformationDto> createInformationData(@RequestBody InformationDto informationDto);
	
	@GetMapping("/{eventId}")
	public ApiResponse<InformationDto> getInformationByEventId(@PathVariable(value = "eventId") Integer eventId);

	@GetMapping("")
	public ApiResponse<List<InformationDto>> getInformationDetails();

	
	@DeleteMapping("/{eventId}")
	public ApiResponse<String> deleteInformationData(@PathVariable(value = "eventId") Integer eventId);
	
	@PatchMapping("")
	public ApiResponse<InformationDto> updateInformationData(@RequestBody InformationDto informationDto);
	
	@PostMapping("/{eventId}/venue-detail")
	public ApiResponse<EventVenueDetailsDto> createVenueData(@PathVariable(value = "eventId") Integer eventId, @RequestBody EventVenueDetailsDto eventVenueDetailsDto);
	
	@GetMapping("/{eventId}/venue-detail")
	public ApiResponse<List<EventVenueDetailsDto>> getVenueDataByEventId(@PathVariable(value = "eventId") Integer eventId);
	
	@GetMapping("/{eventId}/venue-detail/{venueId}")
	public ApiResponse<EventVenueDetailsDto> getVenueDataByEventIdAndVenueId(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "venueId") Integer venueId);

	@DeleteMapping("/{eventId}/venue-detail/{venueId}")
	public ApiResponse<String> deleteVenueData(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "venueId") Integer venueId);
	
	@PatchMapping("/{eventId}/venue-detail")
	public ApiResponse<EventVenueDetailsDto> updateVenueData(@PathVariable(value = "eventId") Integer eventId, @RequestBody EventVenueDetailsDto eventVenueDetailsDto);
	
	@PostMapping("/{eventId}/attendees-detail")
	public ApiResponse<EventAttendeeDetailsDto> createAttendeeData(@PathVariable(value = "eventId") Integer eventId, @RequestBody EventAttendeeDetailsDto eventAttendeeDetailsDto);
	
	@GetMapping("/{eventId}/attendees-detail")
	public ApiResponse<List<EventAttendeeDetailsDto>> getAttendeeDataByEventId(@PathVariable(value = "eventId") Integer eventId);

	@GetMapping("/{eventId}/attendees-detail/{attendeeId}")
	public ApiResponse<EventAttendeeDetailsDto> getAttendeeDataByEventIdAndAttendeeId(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "attendeeId") Integer attendeeId);

	@DeleteMapping("/{eventId}/attendees-detail/{attendeeId}")
	public ApiResponse<String> deleteAttendeeData(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "attendeeId") Integer attendeeId);
	
	@PatchMapping("/{eventId}/attendees-detail")
	public ApiResponse<EventAttendeeDetailsDto> updateAttendeeData(@PathVariable(value = "eventId") Integer eventId, @RequestBody EventAttendeeDetailsDto eventAttendeeDetailsDto);
}
