/**
 * 
 */
package com.climate.decode.eventservice.facade.refrigerantnondrinkablewater;

import java.util.List;

import com.climate.decode.eventservice.dto.refrigerantnondrinkablewater.RefrigerantNonDrinkableWaterDetailsDto;


/**
 * @author diwya
 *
 */
public interface RefrigerantNonDrinkableWaterFacade {

	public RefrigerantNonDrinkableWaterDetailsDto createRefrigerantNonDrinkableWaterDetails(Integer eventId, RefrigerantNonDrinkableWaterDetailsDto refrigerantNonDrinkableWaterDetailsDto);

	public List<RefrigerantNonDrinkableWaterDetailsDto> getRefrigerantNonDrinkableWaterDetailsByEventId(Integer eventId);
	
	public RefrigerantNonDrinkableWaterDetailsDto getRefrigerantNonDrinkableWaterDetailsByEventIdAndRefrigerantNonDrinkableWaterId(Integer eventId, Integer refrigerantNonDrinkableWaterId);

	public String deleteRefrigerantNonDrinkableWaterDetails(Integer eventId, Integer refrigerantNonDrinkableWaterId);

	public RefrigerantNonDrinkableWaterDetailsDto updateRefrigerantNonDrinkableWaterDetails(RefrigerantNonDrinkableWaterDetailsDto refrigerantNonDrinkableWaterDetailsDto);
}
