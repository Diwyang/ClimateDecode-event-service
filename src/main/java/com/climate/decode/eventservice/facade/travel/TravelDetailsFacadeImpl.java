/**
 * 
 */
package com.climate.decode.eventservice.facade.travel;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.travel.TravelDetailsConverter;
import com.climate.decode.eventservice.dto.travel.TravelDetailsDto;
import com.climate.decode.eventservice.entity.travel.TravelDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.service.information.InformationService;
import com.climate.decode.eventservice.service.travel.TravelService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author diwya
 *
 */

@Component
@RequiredArgsConstructor
@Slf4j
public class TravelDetailsFacadeImpl implements TravelDetailsFacade {

	private final TravelDetailsConverter travelDetailsConverter;
	private final TravelService travelService;
	private final InformationService informationService;
	
	@Override
	public TravelDetailsDto createTravelDetails(Integer eventId, TravelDetailsDto payload) {
		log.info("AccommodationFacadeImpl createTravelDetails {}", payload);
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			payload.setEventId(eventId);
			payload.setUpdatedDateTime(OffsetDateTime.now());
			TravelDetails travelDetails = travelDetailsConverter.toEntity(payload);
			return travelDetailsConverter
					.toDto(travelService.createTravelDetailsData(travelDetails));
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public List<TravelDetailsDto> getTravelDetailsByEventId(Integer eventId) {
		log.info("AccommodationFacadeImpl getTravelDetailsByEventId  {}", eventId);
		List<TravelDetailsDto> lstTravelDetailsDto = new ArrayList<>();
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			List<TravelDetails> lstTravelDetails = travelService
					.getTravelDetailsDataByEventId(eventId);
			if (lstTravelDetails.size() > 0) {
				for (TravelDetails accommodationDetail : lstTravelDetails) {
					lstTravelDetailsDto.add(travelDetailsConverter.toDto(accommodationDetail));
				}
			}
			return lstTravelDetailsDto;
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public String deleteTravelDetails(Integer eventId, Integer travelId) {
		log.info("AccommodationFacadeImpl deleteTravelDetails  {} {} ", eventId, travelId);
		Optional<TravelDetails> travelDetails = travelService.getTravelDetailsDataByEventIdAndTravelId(eventId, travelId);
		if (travelDetails.isPresent()) {
			travelService.deleteTravelDetailsData(eventId, travelId);
			return "Data deleted Successfully";
		}
		throw new ResourceNotFoundException(String.format("Record Not Found with eventId {%x} and accommodationId {%x}",
				eventId, travelId));
	}

	@Override
	public TravelDetailsDto updateTravelDetails(TravelDetailsDto travelDetailsDto) {
		log.info("AccommodationFacadeImpl updateTravelDetails  {}", travelDetailsDto);
		travelDetailsDto.setUpdatedDateTime(OffsetDateTime.now());
		return travelDetailsConverter.toDto(travelService.updateTravelDetailsData(travelDetailsConverter.toEntity(travelDetailsDto)));
	}

	@Override
	public TravelDetailsDto getTravelDetailsByEventIdAndTravelId(Integer eventId,
			Integer travelId) {
		log.info("AccommodationFacadeImpl getTravelDetailsByEventId  {}", eventId);
		Optional<TravelDetails> travelDetails = travelService.getTravelDetailsDataByEventIdAndTravelId(eventId, travelId);
		if (travelDetails.isPresent()) {
				return travelDetailsConverter.toDto(travelDetails.get());
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	

}
