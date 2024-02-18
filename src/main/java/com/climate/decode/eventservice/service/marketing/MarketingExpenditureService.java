/**
 * 
 */
package com.climate.decode.eventservice.service.marketing;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.climate.decode.eventservice.entity.marketing.MarketingExpenditureDetails;

/**
 * @author diwya
 *
 */
public interface MarketingExpenditureService {

	public MarketingExpenditureDetails createMarketingExpenditureData(@RequestBody MarketingExpenditureDetails marketingExpenditure);

	public List<MarketingExpenditureDetails> getMarketingExpenditureDataByEventId(Integer eventId);
	
	public Optional<MarketingExpenditureDetails> getMarketingExpenditureDataByEventId(Integer eventId, Integer marketingExpenditureId);

	public void deleteMarketingExpenditureData(Integer eventId, Integer marketingExpenditureId);

	public MarketingExpenditureDetails updateMarketingExpenditureData(MarketingExpenditureDetails marketingExpenditure);
}
