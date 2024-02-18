/**
 * 
 */
package com.climate.decode.eventservice.converter.waste;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.GenericMapper;
import com.climate.decode.eventservice.dto.waste.WasteDetailsDto;
import com.climate.decode.eventservice.entity.waste.WasteDetails;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */
@Component
@RequiredArgsConstructor
public class WasteDetailsConverterImpl implements WasteDetailsConverter {

	private final GenericMapper mapper;
	
	@Override
	public WasteDetails toEntity(WasteDetailsDto dto) {
		return mapper.convert(dto, WasteDetails.class);
	}

	@Override
	public WasteDetailsDto toDto(WasteDetails entity) {
		return mapper.convert(entity, WasteDetailsDto.class);
	}

	@Override
	public WasteDetails updateEntity(WasteDetails entity, WasteDetailsDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
