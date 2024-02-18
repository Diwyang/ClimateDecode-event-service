/**
 * 
 */
package com.climate.decode.eventservice.facade.waste;

import java.util.List;

import com.climate.decode.eventservice.dto.waste.WasteDetailsDto;


/**
 * @author diwya
 *
 */
public interface WasteFacade {

	public WasteDetailsDto createWasteDetails(Integer eventId, WasteDetailsDto wasteDetailsDto);

	public List<WasteDetailsDto> getWasteDetailsByEventId(Integer eventId);
	
	public WasteDetailsDto getWasteDetailsByEventIdAndWasteId(Integer eventId, Integer wasteId);

	public String deleteWasteDetails(Integer eventId, Integer wasteId);

	public WasteDetailsDto updateWasteDetails(WasteDetailsDto wasteDetailsDto);
}
