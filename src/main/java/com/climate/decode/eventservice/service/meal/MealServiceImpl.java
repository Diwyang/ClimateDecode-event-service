package com.climate.decode.eventservice.service.meal;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.eventservice.entity.meal.MealDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.repository.meal.MealDetailsRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MealServiceImpl implements MealService {


	private final MealDetailsRepository repo;
	
	@Override
	public MealDetails createMealData(MealDetails meal) {
		return repo.save(meal);
	}

	@Override
	public List<MealDetails> getMealDataByEventId(Integer eventId) {
		return repo.getByEventId(eventId);
	}

	@Override
	public Optional<MealDetails> getMealDataByEventId(Integer eventId, Integer mealId) {
		return repo.getMealDataByEventIdAndMealId(eventId, mealId);
	}

	@Override
	public void deleteMealData(Integer eventId, Integer mealId) {
		if(repo.getMealDataByEventIdAndMealId(eventId, mealId).isPresent()) {
			repo.delete(repo.getMealDataByEventIdAndMealId(eventId, mealId).get());
		}else {
			throw new ResourceNotFoundException("Event not found with ID "+ eventId);
		}

	}

	@Override
	public MealDetails updateMealData(MealDetails meal) {
		if(repo.getMealDataByEventIdAndMealId(meal.getEventId(), meal.getMealId()).isPresent()) {
			repo.save(meal);
			return repo.getMealDataByEventIdAndMealId(meal.getEventId(), meal.getMealId()).get();
		}else {
			throw new ResourceNotFoundException(String.format("Meal not found For Event ID  {} and Meal ID {}", meal.getEventId(),meal.getMealId()));
		}
	}

}
