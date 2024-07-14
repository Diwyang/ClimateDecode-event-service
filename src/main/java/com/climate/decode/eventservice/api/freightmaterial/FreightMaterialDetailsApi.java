package com.climate.decode.eventservice.api.freightmaterial;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.climate.decode.eventservice.dto.freightmaterial.FreightMaterialDetailsDto;
import com.climate.decode.eventservice.response.ApiResponse;

@RequestMapping("/events/{eventId}/freight-material-details")
public interface FreightMaterialDetailsApi {

	@PostMapping("")
	public ApiResponse<FreightMaterialDetailsDto> createFreightMaterialDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody FreightMaterialDetailsDto dto);
	
	@GetMapping("")
	public ApiResponse<List<FreightMaterialDetailsDto>> getFreightMaterialDetailsByEventId(@PathVariable(value = "eventId") Integer eventId);
	
	@GetMapping("/{freightMaterialId}")
	public ApiResponse<FreightMaterialDetailsDto> getFreightMaterialDetailsByFreightMaterialId(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "freightMaterialId") Integer freightMaterialId);

	
	@DeleteMapping("/{freightMaterialId}")
	public ApiResponse<String> deleteFreightMaterialDetails(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "freightMaterialId") Integer freightMaterialId);
	
	@PatchMapping("")
	public ApiResponse<FreightMaterialDetailsDto> updateFreightMaterialDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody FreightMaterialDetailsDto dto);
}
