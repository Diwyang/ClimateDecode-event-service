/**
 * 
 */
package com.climate.decode.eventservice.service.material;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.eventservice.entity.material.MaterialDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.repository.freightmaterial.MaterialDetailsRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@RequiredArgsConstructor
@Service
public class MaterialServiceImpl implements MaterialService {

	private final MaterialDetailsRepository repo;
	
	@Override
	public MaterialDetails createMaterialDetailsData(MaterialDetails materialDetail) {
		return repo.save(materialDetail);
	}

	@Override
	public List<MaterialDetails> getMaterialDetailsDataByEventId(Integer eventId) {
		return repo.getByEventId(eventId);
	}

	@Override
	public Optional<MaterialDetails> getMaterialDetailsDataByEventIdAndMaterialId(Integer eventId, Integer materialID) {
		return repo.getMaterialDetailsDataByEventIdAndMaterialId(eventId, materialID);
	}

	@Override
	public void deleteMaterialDetailsData(Integer eventId, Integer materialId ) {
		if(repo.getMaterialDetailsDataByEventIdAndMaterialId(eventId, materialId).isPresent()) {
			repo.delete(repo.getMaterialDetailsDataByEventIdAndMaterialId(eventId, materialId).get());
		}else {
			throw new ResourceNotFoundException("Event not found with ID "+ eventId);
		}
	}

	@Override
	public MaterialDetails updateMaterialDetailsData(MaterialDetails materialDetail) {
		if(repo.getMaterialDetailsDataByEventIdAndMaterialId(materialDetail.getEventId(), materialDetail.getMaterialId()).isPresent()) {
			repo.save(materialDetail);
			return repo.getMaterialDetailsDataByEventIdAndMaterialId(materialDetail.getEventId(), materialDetail.getMaterialId()).get();
		}else {
			throw new ResourceNotFoundException("Event not found with ID "+ materialDetail.getEventId());
		}
	}

}
