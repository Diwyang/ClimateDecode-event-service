/**
 * 
 */
package com.climate.decode.eventservice.controllers.meal;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.climate.decode.eventservice.api.meal.MealDetailsApi;
import com.climate.decode.eventservice.dto.meal.MealDetailsDto;
import com.climate.decode.eventservice.facade.meal.MealFacade;
import com.climate.decode.eventservice.response.ApiResponse;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
public class MealController implements MealDetailsApi {

	private final MealFacade mealFacade;

	@Override
	public ApiResponse<MealDetailsDto> createMealDetails(Integer eventId, MealDetailsDto mealDetailsDto) {
		return ApiResponse.ofSuccess(mealFacade.createMealDetails(eventId, mealDetailsDto),
				"Data save successfully");
	}

	@Override
	public ApiResponse<List<MealDetailsDto>> getMealDetailsByEventId(Integer eventId) {
		return ApiResponse.ofSuccess(mealFacade.getMealDetailsByEventId(eventId));
	}

	@Override
	public ApiResponse<String> deleteMealDetails(Integer eventId, Integer mealId) {
		return ApiResponse.ofSuccess(mealFacade.deleteMealDetails(eventId, mealId));
	}

	@Override
	public ApiResponse<MealDetailsDto> updateMealDetails(Integer eventId, MealDetailsDto mealDetailsDto) {
		mealDetailsDto.setEventId(eventId);
		return ApiResponse.ofSuccess(mealFacade.updateMealDetails(mealDetailsDto), "Data Successfully Updated");
	}

	@Override
	public ApiResponse<MealDetailsDto> getMealDetailsByMealId(Integer eventId, Integer mealId) {
		return ApiResponse.ofSuccess(mealFacade.getMealDetailsByEventIdAndMealId(eventId, mealId));
	}

}
