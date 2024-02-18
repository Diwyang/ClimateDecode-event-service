package com.climate.decode.eventservice.api.virtualevent;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.climate.decode.eventservice.dto.virtualevent.VirtualEventDetailsDto;
import com.climate.decode.eventservice.response.ApiResponse;

@RequestMapping("/events/{eventId}/virtual-event-details")
public interface VirtualEventDetailsApi {

	@PostMapping("")
	public ApiResponse<VirtualEventDetailsDto> createVirtualEventDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody VirtualEventDetailsDto virtualEventDetailsDto);
	
	@GetMapping("")
	public ApiResponse<List<VirtualEventDetailsDto>> getVirtualEventDetailsByEventId(@PathVariable(value = "eventId") Integer eventId);
	
	@GetMapping("/{virtualEventId}")
	public ApiResponse<VirtualEventDetailsDto> getVirtualEventDetailsByVirtualEventId(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "virtualEventId") Integer virtualEventId);

	
	@DeleteMapping("/{virtualEventId}")
	public ApiResponse<String> deleteVirtualEventDetails(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "virtualEventId") Integer virtualEventId);
	
	@PatchMapping("")
	public ApiResponse<VirtualEventDetailsDto> updateVirtualEventDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody VirtualEventDetailsDto virtualEventDetailsDto);
	
}
