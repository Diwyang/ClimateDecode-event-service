/**
 * 
 */
package com.climate.decode.eventservice.facade.marketing;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.marketing.MarketingExpenditureDetailsConverter;
import com.climate.decode.eventservice.dto.marketing.MarketingExpenditureDetailsDto;
import com.climate.decode.eventservice.entity.marketing.MarketingExpenditureDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.service.information.InformationService;
import com.climate.decode.eventservice.service.marketing.MarketingExpenditureService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author diwya
 *
 */

@Component
@RequiredArgsConstructor
@Slf4j
public class MarketingExpenditureFacadeImpl implements MarketingExpenditureFacade {

	private final MarketingExpenditureDetailsConverter marketingExpenditureDetailsConverter;
	private final MarketingExpenditureService marketingExpenditureService;
	private final InformationService informationService;
	
	@Override
	public MarketingExpenditureDetailsDto createMarketingExpenditureDetails(Integer eventId, MarketingExpenditureDetailsDto payload) {
		log.info("MarketingExpenditureFacadeImpl createMarketingExpenditureDetails {}", payload);
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			payload.setEventId(eventId);
			payload.setUpdatedDateTime(OffsetDateTime.now());
			MarketingExpenditureDetails marketingExpenditureDetails = marketingExpenditureDetailsConverter.toEntity(payload);
			return marketingExpenditureDetailsConverter
					.toDto(marketingExpenditureService.createMarketingExpenditureData(marketingExpenditureDetails));
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public List<MarketingExpenditureDetailsDto> getMarketingExpenditureDetailsByEventId(Integer eventId) {
		log.info("MarketingExpenditureFacadeImpl getMarketingExpenditureDetailsByEventId  {}", eventId);
		List<MarketingExpenditureDetailsDto> lstMarketingExpenditureDetailsDto = new ArrayList<>();
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			List<MarketingExpenditureDetails> lstMarketingExpenditureDetails = marketingExpenditureService
					.getMarketingExpenditureDataByEventId(eventId);
			if (lstMarketingExpenditureDetails.size() > 0) {
				for (MarketingExpenditureDetails marketingExpenditureDetail : lstMarketingExpenditureDetails) {
					lstMarketingExpenditureDetailsDto.add(marketingExpenditureDetailsConverter.toDto(marketingExpenditureDetail));
				}
			}
			return lstMarketingExpenditureDetailsDto;
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public String deleteMarketingExpenditureDetails(Integer eventId, Integer marketingExpenditureId) {
		log.info("MarketingExpenditureFacadeImpl deleteMarketingExpenditureDetails  {} {} ", eventId, marketingExpenditureId);
		Optional<MarketingExpenditureDetails> marketingExpenditureDetails = marketingExpenditureService.getMarketingExpenditureDataByEventId(eventId, marketingExpenditureId);
		if (marketingExpenditureDetails.isPresent()) {
			marketingExpenditureService.deleteMarketingExpenditureData(eventId, marketingExpenditureId);
			return "Data deleted Successfully";
		}
		throw new ResourceNotFoundException(String.format("Record Not Found with eventId {%x} and marketingExpenditureId {%x}",
				eventId, marketingExpenditureId));
	}

	@Override
	public MarketingExpenditureDetailsDto updateMarketingExpenditureDetails(MarketingExpenditureDetailsDto marketingExpenditureDetailsDto) {
		log.info("MarketingExpenditureFacadeImpl updateMarketingExpenditureDetails  {}", marketingExpenditureDetailsDto);
		marketingExpenditureDetailsDto.setUpdatedDateTime(OffsetDateTime.now());
		return marketingExpenditureDetailsConverter.toDto(marketingExpenditureService.updateMarketingExpenditureData(marketingExpenditureDetailsConverter.toEntity(marketingExpenditureDetailsDto)));
	}

	@Override
	public MarketingExpenditureDetailsDto getMarketingExpenditureDetailsByEventIdAndMarketingExpenditureId(Integer eventId,
			Integer marketingExpenditureId) {
		log.info("MarketingExpenditureFacadeImpl getMarketingExpenditureDetailsByEventId  {}", eventId);
		Optional<MarketingExpenditureDetails> marketingExpenditureDetails = marketingExpenditureService.getMarketingExpenditureDataByEventId(eventId, marketingExpenditureId);
		if (marketingExpenditureDetails.isPresent()) {
				return marketingExpenditureDetailsConverter.toDto(marketingExpenditureDetails.get());
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	

}
