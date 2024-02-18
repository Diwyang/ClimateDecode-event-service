package com.climate.decode.eventservice.api.waste;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.climate.decode.eventservice.dto.waste.WasteDetailsDto;
import com.climate.decode.eventservice.response.ApiResponse;

@RequestMapping("/events/{eventId}/waste-details")
public interface WasteDetailsApi {

	@PostMapping("")
	public ApiResponse<WasteDetailsDto> createWasteDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody WasteDetailsDto wasteDetailsDto);
	
	@GetMapping("")
	public ApiResponse<List<WasteDetailsDto>> getWasteDetailsByEventId(@PathVariable(value = "eventId") Integer eventId);
	
	@GetMapping("/{wasteId}")
	public ApiResponse<WasteDetailsDto> getWasteDetailsByWasteId(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "wasteId") Integer wasteId);

	
	@DeleteMapping("/{wasteId}")
	public ApiResponse<String> deleteWasteDetails(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "wasteId") Integer wasteId);
	
	@PatchMapping("")
	public ApiResponse<WasteDetailsDto> updateWasteDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody WasteDetailsDto wasteDetailsDto);
	
}
