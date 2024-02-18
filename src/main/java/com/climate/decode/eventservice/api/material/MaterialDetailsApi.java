package com.climate.decode.eventservice.api.material;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.climate.decode.eventservice.dto.material.MaterialDetailsDto;
import com.climate.decode.eventservice.response.ApiResponse;

@RequestMapping("/events/{eventId}/material-details")
public interface MaterialDetailsApi {

	@PostMapping("")
	public ApiResponse<MaterialDetailsDto> createMaterialDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody MaterialDetailsDto materialDetailsDto);
	
	@GetMapping("")
	public ApiResponse<List<MaterialDetailsDto>> getMaterialDetailsByEventId(@PathVariable(value = "eventId") Integer eventId);
	
	@GetMapping("/{materialId}")
	public ApiResponse<MaterialDetailsDto> getMaterialDetailsByMaterialId(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "materialId") Integer materialId);

	
	@DeleteMapping("/{materialId}")
	public ApiResponse<String> deleteMaterialDetails(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "materialId") Integer materialId);
	
	@PatchMapping("")
	public ApiResponse<MaterialDetailsDto> updateMaterialDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody MaterialDetailsDto materialDetailsDto);
}
