/**
 * 
 */
package com.climate.decode.eventservice.service.material;

import java.util.List;
import java.util.Optional;

import com.climate.decode.eventservice.entity.material.MaterialDetails;

/**
 * @author diwya
 *
 */
public interface MaterialService {

	public MaterialDetails createMaterialDetailsData(MaterialDetails materialDetail);

	public List<MaterialDetails> getMaterialDetailsDataByEventId(Integer eventId);
	
	public Optional<MaterialDetails> getMaterialDetailsDataByEventIdAndMaterialId(Integer eventId, Integer materialId);

	public void deleteMaterialDetailsData(Integer eventId, Integer materialId);

	public MaterialDetails updateMaterialDetailsData(MaterialDetails materialDetail);
}
