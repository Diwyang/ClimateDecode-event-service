/**
 * 
 */
package com.climate.decode.eventservice.controllers.freightmaterial;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.climate.decode.eventservice.api.freightmaterial.FreightMaterialDetailsApi;
import com.climate.decode.eventservice.dto.freightmaterial.FreightMaterialDetailsDto;
import com.climate.decode.eventservice.facade.freightmaterial.FreightMaterialDetailsFacade;
import com.climate.decode.eventservice.response.ApiResponse;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@RequiredArgsConstructor
@RestController
public class FreightMaterialDetailsController implements FreightMaterialDetailsApi {

	private final FreightMaterialDetailsFacade facade; 
	@Override
	public ApiResponse<FreightMaterialDetailsDto> createFreightMaterialDetails(Integer eventId,
			FreightMaterialDetailsDto dto) {
		return ApiResponse.ofSuccess(facade.createFreightMaterialDetails(eventId, dto),"Data save successfully");
	}

	@Override
	public ApiResponse<List<FreightMaterialDetailsDto>> getFreightMaterialDetailsByEventId(Integer eventId) {
		return ApiResponse.ofSuccess(facade.getFreightMaterialDetailsByEventId(eventId));
	}

	@Override
	public ApiResponse<String> deleteFreightMaterialDetails(Integer eventId, Integer freightMaterialId) {
		return ApiResponse.ofSuccess(facade.deleteFreightMaterialDetails(eventId, freightMaterialId));
	}

	@Override
	public ApiResponse<FreightMaterialDetailsDto> updateFreightMaterialDetails(Integer eventId,
			FreightMaterialDetailsDto dto) {
		dto.setEventId(eventId);
		return ApiResponse.ofSuccess(facade.updateFreightMaterialDetails(dto),"Data Successfully Updated");
	}

	@Override
	public ApiResponse<FreightMaterialDetailsDto> getFreightMaterialDetailsByFreightMaterialId(Integer eventId,
			Integer freightMaterialId) {
		return ApiResponse.ofSuccess(facade.getFreightMaterialDetailsByEventIdAndFreightMaterialId(eventId, freightMaterialId));
	}

}
