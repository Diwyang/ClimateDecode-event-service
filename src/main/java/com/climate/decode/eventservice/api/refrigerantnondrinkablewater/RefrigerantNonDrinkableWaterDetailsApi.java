package com.climate.decode.eventservice.api.refrigerantnondrinkablewater;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.climate.decode.eventservice.dto.refrigerantnondrinkablewater.RefrigerantNonDrinkableWaterDetailsDto;
import com.climate.decode.eventservice.response.ApiResponse;

@RequestMapping("/events/{eventId}/refrigerant-non-drinkable-details")
public interface RefrigerantNonDrinkableWaterDetailsApi {

	@PostMapping("")
	public ApiResponse<RefrigerantNonDrinkableWaterDetailsDto> createRefrigerantNonDrinkableWaterDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody RefrigerantNonDrinkableWaterDetailsDto refrigerantNonDrinkableWaterDetailsDto);
	
	@GetMapping("")
	public ApiResponse<List<RefrigerantNonDrinkableWaterDetailsDto>> getRefrigerantNonDrinkableWaterDetailsByEventId(@PathVariable(value = "eventId") Integer eventId);
	
	@GetMapping("/{refrigerantNonDrinkableWaterId}")
	public ApiResponse<RefrigerantNonDrinkableWaterDetailsDto> getRefrigerantNonDrinkableWaterDetailsByRefrigerantNonDrinkableWaterId(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "refrigerantNonDrinkableWaterId") Integer refrigerantNonDrinkableWaterId);

	
	@DeleteMapping("/{refrigerantNonDrinkableWaterId}")
	public ApiResponse<String> deleteRefrigerantNonDrinkableWaterDetails(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "refrigerantNonDrinkableWaterId") Integer refrigerantNonDrinkableWaterId);
	
	@PatchMapping("")
	public ApiResponse<RefrigerantNonDrinkableWaterDetailsDto> updateRefrigerantNonDrinkableWaterDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody RefrigerantNonDrinkableWaterDetailsDto refrigerantNonDrinkableWaterDetailsDto);
	
}
