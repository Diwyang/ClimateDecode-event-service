/**
 * 
 */
package com.climate.decode.eventservice.service.meal;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.climate.decode.eventservice.entity.meal.MealDetails;

/**
 * @author diwya
 *
 */
public interface MealService {

	public MealDetails createMealData(@RequestBody MealDetails meal);

	public List<MealDetails> getMealDataByEventId(Integer eventId);
	
	public Optional<MealDetails> getMealDataByEventId(Integer eventId, Integer mealId);

	public void deleteMealData(Integer eventId, Integer mealId);

	public MealDetails updateMealData(MealDetails meal);
}
