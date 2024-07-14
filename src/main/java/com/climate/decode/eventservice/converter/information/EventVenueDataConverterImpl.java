package com.climate.decode.eventservice.converter.information;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.GenericMapper;
import com.climate.decode.eventservice.dto.information.EventVenueDetailsDto;
import com.climate.decode.eventservice.entity.information.EventVenueDetails;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class EventVenueDataConverterImpl implements EventVenueDataConverter {

	private final GenericMapper mapper;

	@Override
	public EventVenueDetails toEntity(EventVenueDetailsDto dto) {
		return mapper.convert(dto, EventVenueDetails.class);
	}

	@Override
	public EventVenueDetailsDto toDto(EventVenueDetails entity) {
		return mapper.convert(entity, EventVenueDetailsDto.class);
	}

	@Override
	public EventVenueDetails updateEntity(EventVenueDetails entity, EventVenueDetailsDto dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
