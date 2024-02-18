/**
 * 
 */
package com.climate.decode.eventservice.facade.accommodation;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.accommodation.AccommodationDetailsConverter;
import com.climate.decode.eventservice.dto.accommodation.AccommodationDetailsDto;
import com.climate.decode.eventservice.entity.accommodation.AccommodationDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.service.accommodation.AccommodationService;
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
public class AccommodationFacadeImpl implements AccommodationFacade {

	private final AccommodationDetailsConverter accommodationDetailsConverter;
	private final AccommodationService accommodationService;
	private final InformationService informationService;
	
	@Override
	public AccommodationDetailsDto createAccommodationDetails(Integer eventId, AccommodationDetailsDto payload) {
		log.info("AccommodationFacadeImpl createAccommodationDetails {}", payload);
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			payload.setEventId(eventId);
			payload.setUpdatedDateTime(OffsetDateTime.now());
			AccommodationDetails accommodationDetails = accommodationDetailsConverter.toEntity(payload);
			return accommodationDetailsConverter
					.toDto(accommodationService.createAccommodationData(accommodationDetails));
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public List<AccommodationDetailsDto> getAccommodationDetailsByEventId(Integer eventId) {
		log.info("AccommodationFacadeImpl getAccommodationDetailsByEventId  {}", eventId);
		List<AccommodationDetailsDto> lstAccommodationDetailsDto = new ArrayList<>();
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			List<AccommodationDetails> lstAccommodationDetails = accommodationService
					.getAccommodationDataByEventId(eventId);
			if (lstAccommodationDetails.size() > 0) {
				for (AccommodationDetails accommodationDetail : lstAccommodationDetails) {
					lstAccommodationDetailsDto.add(accommodationDetailsConverter.toDto(accommodationDetail));
				}
			}
			return lstAccommodationDetailsDto;
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public String deleteAccommodationDetails(Integer eventId, Integer accommodationId) {
		log.info("AccommodationFacadeImpl deleteAccommodationDetails  {} {} ", eventId, accommodationId);
		Optional<AccommodationDetails> accommodationDetails = accommodationService.getAccommodationDataByEventId(eventId, accommodationId);
		if (accommodationDetails.isPresent()) {
			accommodationService.deleteAccommodationData(eventId, accommodationId);
			return "Data deleted Successfully";
		}
		throw new ResourceNotFoundException(String.format("Record Not Found with eventId {%x} and accommodationId {%x}",
				eventId, accommodationId));
	}

	@Override
	public AccommodationDetailsDto updateAccommodationDetails(AccommodationDetailsDto accommodationDetailsDto) {
		log.info("AccommodationFacadeImpl updateAccommodationDetails  {}", accommodationDetailsDto);
		accommodationDetailsDto.setUpdatedDateTime(OffsetDateTime.now());
		return accommodationDetailsConverter.toDto(accommodationService.updateAccommodationData(accommodationDetailsConverter.toEntity(accommodationDetailsDto)));
	}

	@Override
	public AccommodationDetailsDto getAccommodationDetailsByEventIdAndAccommodationId(Integer eventId,
			Integer accommodationId) {
		log.info("AccommodationFacadeImpl getAccommodationDetailsByEventId  {}", eventId);
		Optional<AccommodationDetails> accommodationDetails = accommodationService.getAccommodationDataByEventId(eventId, accommodationId);
		if (accommodationDetails.isPresent()) {
				return accommodationDetailsConverter.toDto(accommodationDetails.get());
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	

}
