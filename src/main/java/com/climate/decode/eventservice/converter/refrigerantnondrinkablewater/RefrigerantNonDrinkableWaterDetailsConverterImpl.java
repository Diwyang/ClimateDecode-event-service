/**
 * 
 */
package com.climate.decode.eventservice.converter.refrigerantnondrinkablewater;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.GenericMapper;
import com.climate.decode.eventservice.dto.refrigerantnondrinkablewater.RefrigerantNonDrinkableWaterDetailsDto;
import com.climate.decode.eventservice.entity.refrigerantnondrinkablewater.RefrigerantNonDrinkableWaterDetails;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */
@Component
@RequiredArgsConstructor
public class RefrigerantNonDrinkableWaterDetailsConverterImpl implements RefrigerantNonDrinkableWaterDetailsConverter {

	private final GenericMapper mapper;
	
	@Override
	public RefrigerantNonDrinkableWaterDetails toEntity(RefrigerantNonDrinkableWaterDetailsDto dto) {
		return mapper.convert(dto, RefrigerantNonDrinkableWaterDetails.class);
	}

	@Override
	public RefrigerantNonDrinkableWaterDetailsDto toDto(RefrigerantNonDrinkableWaterDetails entity) {
		return mapper.convert(entity, RefrigerantNonDrinkableWaterDetailsDto.class);
	}

	@Override
	public RefrigerantNonDrinkableWaterDetails updateEntity(RefrigerantNonDrinkableWaterDetails entity, RefrigerantNonDrinkableWaterDetailsDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
