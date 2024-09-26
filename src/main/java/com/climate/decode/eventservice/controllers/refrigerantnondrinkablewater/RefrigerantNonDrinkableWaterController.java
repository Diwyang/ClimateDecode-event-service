/**
 * 
 */
package com.climate.decode.eventservice.controllers.refrigerantnondrinkablewater;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.climate.decode.eventservice.api.refrigerantnondrinkablewater.RefrigerantNonDrinkableWaterDetailsApi;
import com.climate.decode.eventservice.dto.refrigerantnondrinkablewater.RefrigerantNonDrinkableWaterDetailsDto;
import com.climate.decode.eventservice.facade.refrigerantnondrinkablewater.RefrigerantNonDrinkableWaterFacade;
import com.climate.decode.eventservice.response.ApiResponse;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
public class RefrigerantNonDrinkableWaterController implements RefrigerantNonDrinkableWaterDetailsApi {

	private final RefrigerantNonDrinkableWaterFacade refrigerantNonDrinkableWaterFacade;

	@Override
	public ApiResponse<RefrigerantNonDrinkableWaterDetailsDto> createRefrigerantNonDrinkableWaterDetails(Integer eventId, RefrigerantNonDrinkableWaterDetailsDto refrigerantNonDrinkableWaterDetailsDto) {
		return ApiResponse.ofSuccess(refrigerantNonDrinkableWaterFacade.createRefrigerantNonDrinkableWaterDetails(eventId, refrigerantNonDrinkableWaterDetailsDto),
				"Data save successfully");
	}

	@Override
	public ApiResponse<List<RefrigerantNonDrinkableWaterDetailsDto>> getRefrigerantNonDrinkableWaterDetailsByEventId(Integer eventId) {
		return ApiResponse.ofSuccess(refrigerantNonDrinkableWaterFacade.getRefrigerantNonDrinkableWaterDetailsByEventId(eventId));
	}

	@Override
	public ApiResponse<String> deleteRefrigerantNonDrinkableWaterDetails(Integer eventId, Integer refrigerantNonDrinkableWaterId) {
		return ApiResponse.ofSuccess(refrigerantNonDrinkableWaterFacade.deleteRefrigerantNonDrinkableWaterDetails(eventId, refrigerantNonDrinkableWaterId));
	}

	@Override
	public ApiResponse<RefrigerantNonDrinkableWaterDetailsDto> updateRefrigerantNonDrinkableWaterDetails(Integer eventId, RefrigerantNonDrinkableWaterDetailsDto refrigerantNonDrinkableWaterDetailsDto) {
		refrigerantNonDrinkableWaterDetailsDto.setEventId(eventId);
		return ApiResponse.ofSuccess(refrigerantNonDrinkableWaterFacade.updateRefrigerantNonDrinkableWaterDetails(refrigerantNonDrinkableWaterDetailsDto), "Data Successfully Updated");
	}

	@Override
	public ApiResponse<RefrigerantNonDrinkableWaterDetailsDto> getRefrigerantNonDrinkableWaterDetailsByRefrigerantNonDrinkableWaterId(Integer eventId, Integer refrigerantNonDrinkableWaterId) {
		return ApiResponse.ofSuccess(refrigerantNonDrinkableWaterFacade.getRefrigerantNonDrinkableWaterDetailsByEventIdAndRefrigerantNonDrinkableWaterId(eventId, refrigerantNonDrinkableWaterId));
	}

}
