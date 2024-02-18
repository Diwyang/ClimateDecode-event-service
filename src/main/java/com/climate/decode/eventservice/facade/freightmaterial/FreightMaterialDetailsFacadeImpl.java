/**
 * 
 */
package com.climate.decode.eventservice.facade.freightmaterial;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.freightmaterial.FreightMaterialDetailsConverter;
import com.climate.decode.eventservice.dto.freightmaterial.FreightMaterialDetailsDto;
import com.climate.decode.eventservice.entity.freightmaterial.FreightMaterialDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.service.freightmaterial.FreightMaterialService;
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
public class FreightMaterialDetailsFacadeImpl implements FreightMaterialDetailsFacade {

	private final FreightMaterialDetailsConverter converter;
	private final FreightMaterialService service;
	private final InformationService informationService;
	
	@Override
	public FreightMaterialDetailsDto createFreightMaterialDetails(Integer eventId, FreightMaterialDetailsDto payload) {
		log.info("AccommodationFacadeImpl createFreightMaterialDetails {}", payload);
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			payload.setEventId(eventId);
			payload.setUpdatedDateTime(OffsetDateTime.now());
			FreightMaterialDetails details = converter.toEntity(payload);
			return converter
					.toDto(service.createFreightMaterialDetailsData(details));
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public List<FreightMaterialDetailsDto> getFreightMaterialDetailsByEventId(Integer eventId) {
		log.info("AccommodationFacadeImpl getFreightMaterialDetailsByEventId  {}", eventId);
		List<FreightMaterialDetailsDto> lstDetailsDto = new ArrayList<>();
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			List<FreightMaterialDetails> lstDetails = service
					.getFreightMaterialDetailsDataByEventId(eventId);
			if (lstDetails.size() > 0) {
				for (FreightMaterialDetails detail : lstDetails) {
					lstDetailsDto.add(converter.toDto(detail));
				}
			}
			return lstDetailsDto;
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public String deleteFreightMaterialDetails(Integer eventId, Integer freightMaterialId) {
		log.info("AccommodationFacadeImpl deleteFreightMaterialDetails  {} {} ", eventId, freightMaterialId);
		Optional<FreightMaterialDetails> details = service.getFreightMaterialDetailsDataByEventIdAndFreightMaterialId(eventId, freightMaterialId);
		if (details.isPresent()) {
			service.deleteFreightMaterialDetailsData(eventId, freightMaterialId);
			return "Data deleted Successfully";
		}
		throw new ResourceNotFoundException(String.format("Record Not Found with eventId {%x} and accommodationId {%x}",
				eventId, freightMaterialId));
	}

	@Override
	public FreightMaterialDetailsDto updateFreightMaterialDetails(FreightMaterialDetailsDto dto) {
		log.info("AccommodationFacadeImpl updateFreightMaterialDetails  {}", dto);
		dto.setUpdatedDateTime(OffsetDateTime.now());
		return converter.toDto(service.updateFreightMaterialDetailsData(converter.toEntity(dto)));
	}

	@Override
	public FreightMaterialDetailsDto getFreightMaterialDetailsByEventIdAndFreightMaterialId(Integer eventId,
			Integer freightMaterialId) {
		log.info("AccommodationFacadeImpl getFreightMaterialDetailsByEventId  {}", eventId);
		Optional<FreightMaterialDetails> details = service.getFreightMaterialDetailsDataByEventIdAndFreightMaterialId(eventId, freightMaterialId);
		if (details.isPresent()) {
				return converter.toDto(details.get());
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	

}
