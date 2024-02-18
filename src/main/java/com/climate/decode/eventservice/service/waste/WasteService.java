/**
 * 
 */
package com.climate.decode.eventservice.service.waste;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.climate.decode.eventservice.entity.waste.WasteDetails;

/**
 * @author diwya
 *
 */
public interface WasteService {

	public WasteDetails createWasteData(@RequestBody WasteDetails waste);

	public List<WasteDetails> getWasteDataByEventId(Integer eventId);
	
	public Optional<WasteDetails> getWasteDataByEventId(Integer eventId, Integer wasteId);

	public void deleteWasteData(Integer eventId, Integer wasteId);

	public WasteDetails updateWasteData(WasteDetails waste);
}
