/**
 * 
 */
package com.climate.decode.eventservice.controllers.waste;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.climate.decode.eventservice.api.waste.WasteDetailsApi;
import com.climate.decode.eventservice.dto.waste.WasteDetailsDto;
import com.climate.decode.eventservice.facade.waste.WasteFacade;
import com.climate.decode.eventservice.response.ApiResponse;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@RequiredArgsConstructor
@RestController
public class WasteController implements WasteDetailsApi {

	private final WasteFacade wasteFacade;

	@Override
	public ApiResponse<WasteDetailsDto> createWasteDetails(Integer eventId, WasteDetailsDto wasteDetailsDto) {
		return ApiResponse.ofSuccess(wasteFacade.createWasteDetails(eventId, wasteDetailsDto),
				"Data save successfully");
	}

	@Override
	public ApiResponse<List<WasteDetailsDto>> getWasteDetailsByEventId(Integer eventId) {
		return ApiResponse.ofSuccess(wasteFacade.getWasteDetailsByEventId(eventId));
	}

	@Override
	public ApiResponse<String> deleteWasteDetails(Integer eventId, Integer wasteId) {
		return ApiResponse.ofSuccess(wasteFacade.deleteWasteDetails(eventId, wasteId));
	}

	@Override
	public ApiResponse<WasteDetailsDto> updateWasteDetails(Integer eventId, WasteDetailsDto wasteDetailsDto) {
		wasteDetailsDto.setEventId(eventId);
		return ApiResponse.ofSuccess(wasteFacade.updateWasteDetails(wasteDetailsDto), "Data Successfully Updated");
	}

	@Override
	public ApiResponse<WasteDetailsDto> getWasteDetailsByWasteId(Integer eventId, Integer wasteId) {
		return ApiResponse.ofSuccess(wasteFacade.getWasteDetailsByEventIdAndWasteId(eventId, wasteId));
	}

}
