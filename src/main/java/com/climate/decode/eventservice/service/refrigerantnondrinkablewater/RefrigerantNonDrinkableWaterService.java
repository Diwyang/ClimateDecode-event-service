/**
 * 
 */
package com.climate.decode.eventservice.service.refrigerantnondrinkablewater;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.climate.decode.eventservice.entity.refrigerantnondrinkablewater.RefrigerantNonDrinkableWaterDetails;

/**
 * @author diwya
 *
 */
public interface RefrigerantNonDrinkableWaterService {

	public RefrigerantNonDrinkableWaterDetails createRefrigerantNonDrinkableWaterData(@RequestBody RefrigerantNonDrinkableWaterDetails refrigerantNonDrinkableWater);

	public List<RefrigerantNonDrinkableWaterDetails> getRefrigerantNonDrinkableWaterDataByEventId(Integer eventId);
	
	public Optional<RefrigerantNonDrinkableWaterDetails> getRefrigerantNonDrinkableWaterDataByEventId(Integer eventId, Integer refrigerantNonDrinkableWaterId);

	public void deleteRefrigerantNonDrinkableWaterData(Integer eventId, Integer refrigerantNonDrinkableWaterId);

	public RefrigerantNonDrinkableWaterDetails updateRefrigerantNonDrinkableWaterData(RefrigerantNonDrinkableWaterDetails refrigerantNonDrinkableWater);
}
