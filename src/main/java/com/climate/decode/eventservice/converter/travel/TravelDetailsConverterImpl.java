/**
 * 
 */
package com.climate.decode.eventservice.converter.travel;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.GenericMapper;
import com.climate.decode.eventservice.dto.travel.TravelDetailsDto;
import com.climate.decode.eventservice.entity.travel.TravelDetails;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */
@Component
@RequiredArgsConstructor
public class TravelDetailsConverterImpl implements TravelDetailsConverter {

	private final GenericMapper mapper;
	
	@Override
	public TravelDetails toEntity(TravelDetailsDto dto) {
		return mapper.convert(dto, TravelDetails.class);
	}

	@Override
	public TravelDetailsDto toDto(TravelDetails entity) {
		return mapper.convert(entity, TravelDetailsDto.class);
	}

	@Override
	public TravelDetails updateEntity(TravelDetails entity, TravelDetailsDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
