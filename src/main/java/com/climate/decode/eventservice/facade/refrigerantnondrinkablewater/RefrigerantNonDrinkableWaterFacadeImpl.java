/**
 * 
 */
package com.climate.decode.eventservice.facade.refrigerantnondrinkablewater;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.refrigerantnondrinkablewater.RefrigerantNonDrinkableWaterDetailsConverter;
import com.climate.decode.eventservice.dto.refrigerantnondrinkablewater.RefrigerantNonDrinkableWaterDetailsDto;
import com.climate.decode.eventservice.entity.refrigerantnondrinkablewater.RefrigerantNonDrinkableWaterDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.service.information.InformationService;
import com.climate.decode.eventservice.service.refrigerantnondrinkablewater.RefrigerantNonDrinkableWaterService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author diwya
 *
 */

@Component
@RequiredArgsConstructor
@Slf4j
public class RefrigerantNonDrinkableWaterFacadeImpl implements RefrigerantNonDrinkableWaterFacade {

	private final RefrigerantNonDrinkableWaterDetailsConverter refrigerantNonDrinkableWaterDetailsConverter;
	private final RefrigerantNonDrinkableWaterService refrigerantNonDrinkableWaterService;
	private final InformationService informationService;
	
	@Override
	public RefrigerantNonDrinkableWaterDetailsDto createRefrigerantNonDrinkableWaterDetails(Integer eventId, RefrigerantNonDrinkableWaterDetailsDto payload) {
		log.info("RefrigerantNonDrinkableWaterFacadeImpl createRefrigerantNonDrinkableWaterDetails {}", payload);
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			payload.setEventId(eventId);
			payload.setUpdatedDateTime(OffsetDateTime.now());
			RefrigerantNonDrinkableWaterDetails refrigerantNonDrinkableWaterDetails = refrigerantNonDrinkableWaterDetailsConverter.toEntity(payload);
			return refrigerantNonDrinkableWaterDetailsConverter
					.toDto(refrigerantNonDrinkableWaterService.createRefrigerantNonDrinkableWaterData(refrigerantNonDrinkableWaterDetails));
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public List<RefrigerantNonDrinkableWaterDetailsDto> getRefrigerantNonDrinkableWaterDetailsByEventId(Integer eventId) {
		log.info("RefrigerantNonDrinkableWaterFacadeImpl getRefrigerantNonDrinkableWaterDetailsByEventId  {}", eventId);
		List<RefrigerantNonDrinkableWaterDetailsDto> lstRefrigerantNonDrinkableWaterDetailsDto = new ArrayList<>();
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			List<RefrigerantNonDrinkableWaterDetails> lstRefrigerantNonDrinkableWaterDetails = refrigerantNonDrinkableWaterService
					.getRefrigerantNonDrinkableWaterDataByEventId(eventId);
			if (lstRefrigerantNonDrinkableWaterDetails.size() > 0) {
				for (RefrigerantNonDrinkableWaterDetails refrigerantNonDrinkableWaterDetail : lstRefrigerantNonDrinkableWaterDetails) {
					lstRefrigerantNonDrinkableWaterDetailsDto.add(refrigerantNonDrinkableWaterDetailsConverter.toDto(refrigerantNonDrinkableWaterDetail));
				}
			}
			return lstRefrigerantNonDrinkableWaterDetailsDto;
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public String deleteRefrigerantNonDrinkableWaterDetails(Integer eventId, Integer refrigerantNonDrinkableWaterId) {
		log.info("RefrigerantNonDrinkableWaterFacadeImpl deleteRefrigerantNonDrinkableWaterDetails  {} {} ", eventId, refrigerantNonDrinkableWaterId);
		Optional<RefrigerantNonDrinkableWaterDetails> refrigerantNonDrinkableWaterDetails = refrigerantNonDrinkableWaterService.getRefrigerantNonDrinkableWaterDataByEventId(eventId, refrigerantNonDrinkableWaterId);
		if (refrigerantNonDrinkableWaterDetails.isPresent()) {
			refrigerantNonDrinkableWaterService.deleteRefrigerantNonDrinkableWaterData(eventId, refrigerantNonDrinkableWaterId);
			return "Data deleted Successfully";
		}
		throw new ResourceNotFoundException(String.format("Record Not Found with eventId {%x} and refrigerantNonDrinkableWaterId {%x}",
				eventId, refrigerantNonDrinkableWaterId));
	}

	@Override
	public RefrigerantNonDrinkableWaterDetailsDto updateRefrigerantNonDrinkableWaterDetails(RefrigerantNonDrinkableWaterDetailsDto refrigerantNonDrinkableWaterDetailsDto) {
		log.info("RefrigerantNonDrinkableWaterFacadeImpl updateRefrigerantNonDrinkableWaterDetails  {}", refrigerantNonDrinkableWaterDetailsDto);
		refrigerantNonDrinkableWaterDetailsDto.setUpdatedDateTime(OffsetDateTime.now());
		return refrigerantNonDrinkableWaterDetailsConverter.toDto(refrigerantNonDrinkableWaterService.updateRefrigerantNonDrinkableWaterData(refrigerantNonDrinkableWaterDetailsConverter.toEntity(refrigerantNonDrinkableWaterDetailsDto)));
	}

	@Override
	public RefrigerantNonDrinkableWaterDetailsDto getRefrigerantNonDrinkableWaterDetailsByEventIdAndRefrigerantNonDrinkableWaterId(Integer eventId,
			Integer refrigerantNonDrinkableWaterId) {
		log.info("RefrigerantNonDrinkableWaterFacadeImpl getRefrigerantNonDrinkableWaterDetailsByEventId  {}", eventId);
		Optional<RefrigerantNonDrinkableWaterDetails> refrigerantNonDrinkableWaterDetails = refrigerantNonDrinkableWaterService.getRefrigerantNonDrinkableWaterDataByEventId(eventId, refrigerantNonDrinkableWaterId);
		if (refrigerantNonDrinkableWaterDetails.isPresent()) {
				return refrigerantNonDrinkableWaterDetailsConverter.toDto(refrigerantNonDrinkableWaterDetails.get());
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	

}
