package com.climate.decode.eventservice.converter.information;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.GenericMapper;
import com.climate.decode.eventservice.dto.information.InformationDto;
import com.climate.decode.eventservice.entity.information.Information;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class InformationConverterImpl implements InformationConverter {

	private final GenericMapper mapper;
	
	@Override
	public Information toEntity(InformationDto dto) {
		return mapper.convert(dto, Information.class);
	}

	@Override
	public InformationDto toDto(Information entity) {
		return mapper.convert(entity, InformationDto.class);
	}

	@Override
	public Information updateEntity(Information entity, InformationDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
