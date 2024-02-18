package com.climate.decode.eventservice.service.marketing;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.eventservice.entity.marketing.MarketingExpenditureDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.repository.marketing.MarketingExpenditureDetailsRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MarketingExpenditureServiceImpl implements MarketingExpenditureService {


	private final MarketingExpenditureDetailsRepository repo;
	
	@Override
	public MarketingExpenditureDetails createMarketingExpenditureData(MarketingExpenditureDetails marketingExpenditure) {
		return repo.save(marketingExpenditure);
	}

	@Override
	public List<MarketingExpenditureDetails> getMarketingExpenditureDataByEventId(Integer eventId) {
		return repo.getByEventId(eventId);
	}

	@Override
	public Optional<MarketingExpenditureDetails> getMarketingExpenditureDataByEventId(Integer eventId, Integer marketingExpenditureId) {
		return repo.getMarketingExpenditureDataByEventIdAndMarketingId(eventId, marketingExpenditureId);
	}

	@Override
	public void deleteMarketingExpenditureData(Integer eventId, Integer marketingId) {
		if(repo.getMarketingExpenditureDataByEventIdAndMarketingId(eventId, marketingId).isPresent()) {
			repo.delete(repo.getMarketingExpenditureDataByEventIdAndMarketingId(eventId, marketingId).get());
		}else {
			throw new ResourceNotFoundException("Event not found with ID "+ eventId);
		}

	}

	@Override
	public MarketingExpenditureDetails updateMarketingExpenditureData(MarketingExpenditureDetails marketingExpenditure) {
		if(repo.getMarketingExpenditureDataByEventIdAndMarketingId(marketingExpenditure.getEventId(), marketingExpenditure.getMarketingId()).isPresent()) {
			repo.save(marketingExpenditure);
			return repo.getMarketingExpenditureDataByEventIdAndMarketingId(marketingExpenditure.getEventId(), marketingExpenditure.getMarketingId()).get();
		}else {
			throw new ResourceNotFoundException(String.format("MarketingExpenditure not found For Event ID  {} and MarketingExpenditure ID {}", marketingExpenditure.getEventId(),marketingExpenditure.getMarketingId()));
		}
	}

}
