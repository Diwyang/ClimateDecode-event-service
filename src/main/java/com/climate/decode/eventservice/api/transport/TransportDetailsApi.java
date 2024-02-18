package com.climate.decode.eventservice.api.transport;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.climate.decode.eventservice.dto.transport.TransportDetailsDto;
import com.climate.decode.eventservice.response.ApiResponse;

@RequestMapping("/events/{eventId}/transport-details")
public interface TransportDetailsApi {

	@PostMapping("")
	public ApiResponse<TransportDetailsDto> createTransportDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody TransportDetailsDto transportDetailsDto);
	
	@GetMapping("")
	public ApiResponse<List<TransportDetailsDto>> getTransportDetailsByEventId(@PathVariable(value = "eventId") Integer eventId);
	
	@GetMapping("/{transportId}")
	public ApiResponse<TransportDetailsDto> getTransportDetailsByTransportId(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "transportId") Integer transportId);

	
	@DeleteMapping("/{transportId}")
	public ApiResponse<String> deleteTransportDetails(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "transportId") Integer transportId);
	
	@PatchMapping("")
	public ApiResponse<TransportDetailsDto> updateTransportDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody TransportDetailsDto transportDetailsDto);
}
