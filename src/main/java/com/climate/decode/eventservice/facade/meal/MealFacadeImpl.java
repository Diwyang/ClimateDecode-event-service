/**
 * 
 */
package com.climate.decode.eventservice.facade.meal;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.meal.MealDetailsConverter;
import com.climate.decode.eventservice.dto.meal.MealDetailsDto;
import com.climate.decode.eventservice.entity.meal.MealDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.service.meal.MealService;
import com.climate.decode.eventservice.service.information.InformationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author diwya
 *
 */

@Component
@RequiredArgsConstructor
@Slf4j
public class MealFacadeImpl implements MealFacade {

	private final MealDetailsConverter mealDetailsConverter;
	private final MealService mealService;
	private final InformationService informationService;
	
	@Override
	public MealDetailsDto createMealDetails(Integer eventId, MealDetailsDto payload) {
		log.info("MealFacadeImpl createMealDetails {}", payload);
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			payload.setEventId(eventId);
			payload.setUpdatedDateTime(OffsetDateTime.now());
			MealDetails mealDetails = mealDetailsConverter.toEntity(payload);
			return mealDetailsConverter
					.toDto(mealService.createMealData(mealDetails));
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public List<MealDetailsDto> getMealDetailsByEventId(Integer eventId) {
		log.info("MealFacadeImpl getMealDetailsByEventId  {}", eventId);
		List<MealDetailsDto> lstMealDetailsDto = new ArrayList<>();
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			List<MealDetails> lstMealDetails = mealService
					.getMealDataByEventId(eventId);
			if (lstMealDetails.size() > 0) {
				for (MealDetails mealDetail : lstMealDetails) {
					lstMealDetailsDto.add(mealDetailsConverter.toDto(mealDetail));
				}
			}
			return lstMealDetailsDto;
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public String deleteMealDetails(Integer eventId, Integer mealId) {
		log.info("MealFacadeImpl deleteMealDetails  {} {} ", eventId, mealId);
		Optional<MealDetails> mealDetails = mealService.getMealDataByEventId(eventId, mealId);
		if (mealDetails.isPresent()) {
			mealService.deleteMealData(eventId, mealId);
			return "Data deleted Successfully";
		}
		throw new ResourceNotFoundException(String.format("Record Not Found with eventId {%x} and mealId {%x}",
				eventId, mealId));
	}

	@Override
	public MealDetailsDto updateMealDetails(MealDetailsDto mealDetailsDto) {
		log.info("MealFacadeImpl updateMealDetails  {}", mealDetailsDto);
		mealDetailsDto.setUpdatedDateTime(OffsetDateTime.now());
		return mealDetailsConverter.toDto(mealService.updateMealData(mealDetailsConverter.toEntity(mealDetailsDto)));
	}

	@Override
	public MealDetailsDto getMealDetailsByEventIdAndMealId(Integer eventId,
			Integer mealId) {
		log.info("MealFacadeImpl getMealDetailsByEventId  {}", eventId);
		Optional<MealDetails> mealDetails = mealService.getMealDataByEventId(eventId, mealId);
		if (mealDetails.isPresent()) {
				return mealDetailsConverter.toDto(mealDetails.get());
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	

}
