/**
 * 
 */
package com.climate.decode.eventservice.converter.accommodation;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.GenericMapper;
import com.climate.decode.eventservice.dto.accommodation.AccommodationDetailsDto;
import com.climate.decode.eventservice.entity.accommodation.AccommodationDetails;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */
@Component
@RequiredArgsConstructor
public class AccommodationDetailsConverterImpl implements AccommodationDetailsConverter {

	private final GenericMapper mapper;
	
	@Override
	public AccommodationDetails toEntity(AccommodationDetailsDto dto) {
		return mapper.convert(dto, AccommodationDetails.class);
	}

	@Override
	public AccommodationDetailsDto toDto(AccommodationDetails entity) {
		return mapper.convert(entity, AccommodationDetailsDto.class);
	}

	@Override
	public AccommodationDetails updateEntity(AccommodationDetails entity, AccommodationDetailsDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
