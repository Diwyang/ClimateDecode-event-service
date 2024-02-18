/**
 * 
 */
package com.climate.decode.eventservice.service.freightmaterial;

import java.util.List;
import java.util.Optional;

import com.climate.decode.eventservice.entity.freightmaterial.FreightMaterialDetails;

/**
 * @author diwya
 *
 */
public interface FreightMaterialService {

	public FreightMaterialDetails createFreightMaterialDetailsData(FreightMaterialDetails freightMaterialDetail);

	public List<FreightMaterialDetails> getFreightMaterialDetailsDataByEventId(Integer eventId);
	
	public Optional<FreightMaterialDetails> getFreightMaterialDetailsDataByEventIdAndFreightMaterialId(Integer eventId, Integer freightMaterialId);

	public void deleteFreightMaterialDetailsData(Integer eventId, Integer freightMaterialId);

	public FreightMaterialDetails updateFreightMaterialDetailsData(FreightMaterialDetails freightMaterialDetail);
}
