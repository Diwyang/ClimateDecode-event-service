/**
 * 
 */
package com.climate.decode.eventservice.facade.material;

import java.util.List;

import com.climate.decode.eventservice.dto.material.MaterialDetailsDto;

/**
 * @author diwya
 *
 */
public interface MaterialDetailsFacade {

	public MaterialDetailsDto createMaterialDetails(Integer eventId, MaterialDetailsDto materialDetailsDto);

	public List<MaterialDetailsDto> getMaterialDetailsByEventId(Integer eventId);
	
	public MaterialDetailsDto getMaterialDetailsByEventIdAndMaterialId(Integer eventId, Integer materialId);

	public String deleteMaterialDetails(Integer eventId, Integer materialId);

	public MaterialDetailsDto updateMaterialDetails(MaterialDetailsDto materialDetailsDto);
}
