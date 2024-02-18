/**
 * 
 */
package com.climate.decode.eventservice.converter.transport;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.GenericMapper;
import com.climate.decode.eventservice.dto.transport.TransportDetailsDto;
import com.climate.decode.eventservice.entity.transport.TransportDetails;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */
@Component
@RequiredArgsConstructor
public class TransportDetailsConverterImpl implements TransportDetailsConverter {

	private final GenericMapper mapper;
	
	@Override
	public TransportDetails toEntity(TransportDetailsDto dto) {
		return mapper.convert(dto, TransportDetails.class);
	}

	@Override
	public TransportDetailsDto toDto(TransportDetails entity) {
		return mapper.convert(entity, TransportDetailsDto.class);
	}

	@Override
	public TransportDetails updateEntity(TransportDetails entity, TransportDetailsDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
