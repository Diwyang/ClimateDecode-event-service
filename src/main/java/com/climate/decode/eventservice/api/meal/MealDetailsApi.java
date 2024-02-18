package com.climate.decode.eventservice.api.meal;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.climate.decode.eventservice.dto.meal.MealDetailsDto;
import com.climate.decode.eventservice.response.ApiResponse;

@RequestMapping("/events/{eventId}/meal-details")
public interface MealDetailsApi {

	@PostMapping("")
	public ApiResponse<MealDetailsDto> createMealDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody MealDetailsDto mealDetailsDto);
	
	@GetMapping("")
	public ApiResponse<List<MealDetailsDto>> getMealDetailsByEventId(@PathVariable(value = "eventId") Integer eventId);
	
	@GetMapping("/{mealId}")
	public ApiResponse<MealDetailsDto> getMealDetailsByMealId(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "mealId") Integer mealId);

	
	@DeleteMapping("/{mealId}")
	public ApiResponse<String> deleteMealDetails(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "mealId") Integer mealId);
	
	@PatchMapping("")
	public ApiResponse<MealDetailsDto> updateMealDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody MealDetailsDto mealDetailsDto);
	
}
