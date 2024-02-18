/**
 * 
 */
package com.climate.decode.eventservice.converter.marketing;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.GenericMapper;
import com.climate.decode.eventservice.dto.marketing.MarketingExpenditureDetailsDto;
import com.climate.decode.eventservice.entity.marketing.MarketingExpenditureDetails;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */
@Component
@RequiredArgsConstructor
public class MarketingExpenditureDetailsConverterImpl implements MarketingExpenditureDetailsConverter {

	private final GenericMapper mapper;
	
	@Override
	public MarketingExpenditureDetails toEntity(MarketingExpenditureDetailsDto dto) {
		return mapper.convert(dto, MarketingExpenditureDetails.class);
	}

	@Override
	public MarketingExpenditureDetailsDto toDto(MarketingExpenditureDetails entity) {
		return mapper.convert(entity, MarketingExpenditureDetailsDto.class);
	}

	@Override
	public MarketingExpenditureDetails updateEntity(MarketingExpenditureDetails entity, MarketingExpenditureDetailsDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
