/**
 * 
 */
package com.climate.decode.eventservice.converter.venue;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.GenericMapper;
import com.climate.decode.eventservice.dto.venue.VenueDetailsDto;
import com.climate.decode.eventservice.entity.venue.VenueDetails;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */
@Component
@RequiredArgsConstructor
public class VenueDetailsConverterImpl implements VenueDetailsConverter {

	private final GenericMapper mapper;
	
	@Override
	public VenueDetails toEntity(VenueDetailsDto dto) {
		return mapper.convert(dto, VenueDetails.class);
	}

	@Override
	public VenueDetailsDto toDto(VenueDetails entity) {
		return mapper.convert(entity, VenueDetailsDto.class);
	}

	@Override
	public VenueDetails updateEntity(VenueDetails entity, VenueDetailsDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
