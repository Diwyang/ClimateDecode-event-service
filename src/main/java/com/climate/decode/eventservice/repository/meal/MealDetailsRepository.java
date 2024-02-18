/**
 * 
 */
package com.climate.decode.eventservice.repository.meal;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.eventservice.entity.meal.MealDetails;

/**
 * @author diwya
 *
 */
public interface MealDetailsRepository extends JpaRepository<MealDetails, Long>  {

	List<MealDetails> getByEventId(Integer eventId);

	Optional<MealDetails> getByMealId(Integer mealId);

	Optional<MealDetails> getMealDataByEventIdAndMealId(Integer eventId, Integer mealId);
	
}
