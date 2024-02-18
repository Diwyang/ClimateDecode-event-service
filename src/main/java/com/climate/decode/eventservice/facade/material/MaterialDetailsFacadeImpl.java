/**
 * 
 */
package com.climate.decode.eventservice.facade.material;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.material.MaterialDetailsConverter;
import com.climate.decode.eventservice.dto.material.MaterialDetailsDto;
import com.climate.decode.eventservice.entity.material.MaterialDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.service.information.InformationService;
import com.climate.decode.eventservice.service.material.MaterialService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author diwya
 *
 */

@Component
@RequiredArgsConstructor
@Slf4j
public class MaterialDetailsFacadeImpl implements MaterialDetailsFacade {

	private final MaterialDetailsConverter materialDetailsConverter;
	private final MaterialService materialService;
	private final InformationService informationService;
	
	@Override
	public MaterialDetailsDto createMaterialDetails(Integer eventId, MaterialDetailsDto payload) {
		log.info("AccommodationFacadeImpl createMaterialDetails {}", payload);
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			payload.setEventId(eventId);
			payload.setUpdatedDateTime(OffsetDateTime.now());
			MaterialDetails materialDetails = materialDetailsConverter.toEntity(payload);
			return materialDetailsConverter
					.toDto(materialService.createMaterialDetailsData(materialDetails));
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public List<MaterialDetailsDto> getMaterialDetailsByEventId(Integer eventId) {
		log.info("AccommodationFacadeImpl getMaterialDetailsByEventId  {}", eventId);
		List<MaterialDetailsDto> lstMaterialDetailsDto = new ArrayList<>();
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			List<MaterialDetails> lstMaterialDetails = materialService
					.getMaterialDetailsDataByEventId(eventId);
			if (lstMaterialDetails.size() > 0) {
				for (MaterialDetails materialDetail : lstMaterialDetails) {
					lstMaterialDetailsDto.add(materialDetailsConverter.toDto(materialDetail));
				}
			}
			return lstMaterialDetailsDto;
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public String deleteMaterialDetails(Integer eventId, Integer materialId) {
		log.info("AccommodationFacadeImpl deleteMaterialDetails  {} {} ", eventId, materialId);
		Optional<MaterialDetails> materialDetails = materialService.getMaterialDetailsDataByEventIdAndMaterialId(eventId, materialId);
		if (materialDetails.isPresent()) {
			materialService.deleteMaterialDetailsData(eventId, materialId);
			return "Data deleted Successfully";
		}
		throw new ResourceNotFoundException(String.format("Record Not Found with eventId {%x} and accommodationId {%x}",
				eventId, materialId));
	}

	@Override
	public MaterialDetailsDto updateMaterialDetails(MaterialDetailsDto materialDetailsDto) {
		log.info("AccommodationFacadeImpl updateMaterialDetails  {}", materialDetailsDto);
		materialDetailsDto.setUpdatedDateTime(OffsetDateTime.now());
		return materialDetailsConverter.toDto(materialService.updateMaterialDetailsData(materialDetailsConverter.toEntity(materialDetailsDto)));
	}

	@Override
	public MaterialDetailsDto getMaterialDetailsByEventIdAndMaterialId(Integer eventId,
			Integer materialId) {
		log.info("AccommodationFacadeImpl getMaterialDetailsByEventId  {}", eventId);
		Optional<MaterialDetails> materialDetails = materialService.getMaterialDetailsDataByEventIdAndMaterialId(eventId, materialId);
		if (materialDetails.isPresent()) {
				return materialDetailsConverter.toDto(materialDetails.get());
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	

}
