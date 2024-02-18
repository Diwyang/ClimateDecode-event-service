/**
 * 
 */
package com.climate.decode.eventservice.facade.waste;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.waste.WasteDetailsConverter;
import com.climate.decode.eventservice.dto.waste.WasteDetailsDto;
import com.climate.decode.eventservice.entity.waste.WasteDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.service.waste.WasteService;
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
public class WasteFacadeImpl implements WasteFacade {

	private final WasteDetailsConverter wasteDetailsConverter;
	private final WasteService wasteService;
	private final InformationService informationService;
	
	@Override
	public WasteDetailsDto createWasteDetails(Integer eventId, WasteDetailsDto payload) {
		log.info("WasteFacadeImpl createWasteDetails {}", payload);
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			payload.setEventId(eventId);
			payload.setUpdatedDateTime(OffsetDateTime.now());
			WasteDetails wasteDetails = wasteDetailsConverter.toEntity(payload);
			return wasteDetailsConverter
					.toDto(wasteService.createWasteData(wasteDetails));
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public List<WasteDetailsDto> getWasteDetailsByEventId(Integer eventId) {
		log.info("WasteFacadeImpl getWasteDetailsByEventId  {}", eventId);
		List<WasteDetailsDto> lstWasteDetailsDto = new ArrayList<>();
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			List<WasteDetails> lstWasteDetails = wasteService
					.getWasteDataByEventId(eventId);
			if (lstWasteDetails.size() > 0) {
				for (WasteDetails wasteDetail : lstWasteDetails) {
					lstWasteDetailsDto.add(wasteDetailsConverter.toDto(wasteDetail));
				}
			}
			return lstWasteDetailsDto;
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public String deleteWasteDetails(Integer eventId, Integer wasteId) {
		log.info("WasteFacadeImpl deleteWasteDetails  {} {} ", eventId, wasteId);
		Optional<WasteDetails> wasteDetails = wasteService.getWasteDataByEventId(eventId, wasteId);
		if (wasteDetails.isPresent()) {
			wasteService.deleteWasteData(eventId, wasteId);
			return "Data deleted Successfully";
		}
		throw new ResourceNotFoundException(String.format("Record Not Found with eventId {%x} and wasteId {%x}",
				eventId, wasteId));
	}

	@Override
	public WasteDetailsDto updateWasteDetails(WasteDetailsDto wasteDetailsDto) {
		log.info("WasteFacadeImpl updateWasteDetails  {}", wasteDetailsDto);
		wasteDetailsDto.setUpdatedDateTime(OffsetDateTime.now());
		return wasteDetailsConverter.toDto(wasteService.updateWasteData(wasteDetailsConverter.toEntity(wasteDetailsDto)));
	}

	@Override
	public WasteDetailsDto getWasteDetailsByEventIdAndWasteId(Integer eventId,
			Integer wasteId) {
		log.info("WasteFacadeImpl getWasteDetailsByEventId  {}", eventId);
		Optional<WasteDetails> wasteDetails = wasteService.getWasteDataByEventId(eventId, wasteId);
		if (wasteDetails.isPresent()) {
				return wasteDetailsConverter.toDto(wasteDetails.get());
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	

}
