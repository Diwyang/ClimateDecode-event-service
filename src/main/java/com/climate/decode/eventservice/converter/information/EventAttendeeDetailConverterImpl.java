package com.climate.decode.eventservice.converter.information;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.GenericMapper;
import com.climate.decode.eventservice.dto.information.EventAttendeeDetailsDto;
import com.climate.decode.eventservice.entity.information.EventAttendeeDetails;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class EventAttendeeDetailConverterImpl implements EventAttendeeDetailConverter {

	private final GenericMapper mapper;

	@Override
	public EventAttendeeDetails toEntity(EventAttendeeDetailsDto dto) {
		return mapper.convert(dto, EventAttendeeDetails.class);
	}

	@Override
	public EventAttendeeDetailsDto toDto(EventAttendeeDetails entity) {
		return mapper.convert(entity, EventAttendeeDetailsDto.class);
	}

	@Override
	public EventAttendeeDetails updateEntity(EventAttendeeDetails entity, EventAttendeeDetailsDto dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
