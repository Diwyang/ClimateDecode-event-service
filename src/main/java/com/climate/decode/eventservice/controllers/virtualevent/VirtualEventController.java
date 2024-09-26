/**
 * 
 */
package com.climate.decode.eventservice.controllers.virtualevent;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.climate.decode.eventservice.api.virtualevent.VirtualEventDetailsApi;
import com.climate.decode.eventservice.dto.virtualevent.VirtualEventDetailsDto;
import com.climate.decode.eventservice.facade.virtualevent.VirtualEventFacade;
import com.climate.decode.eventservice.response.ApiResponse;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
public class VirtualEventController implements VirtualEventDetailsApi {

	private final VirtualEventFacade virtualEventFacade;

	@Override
	public ApiResponse<VirtualEventDetailsDto> createVirtualEventDetails(Integer eventId, VirtualEventDetailsDto virtualEventDetailsDto) {
		return ApiResponse.ofSuccess(virtualEventFacade.createVirtualEventDetails(eventId, virtualEventDetailsDto),
				"Data save successfully");
	}

	@Override
	public ApiResponse<List<VirtualEventDetailsDto>> getVirtualEventDetailsByEventId(Integer eventId) {
		return ApiResponse.ofSuccess(virtualEventFacade.getVirtualEventDetailsByEventId(eventId));
	}

	@Override
	public ApiResponse<String> deleteVirtualEventDetails(Integer eventId, Integer virtualEventId) {
		return ApiResponse.ofSuccess(virtualEventFacade.deleteVirtualEventDetails(eventId, virtualEventId));
	}

	@Override
	public ApiResponse<VirtualEventDetailsDto> updateVirtualEventDetails(Integer eventId, VirtualEventDetailsDto virtualEventDetailsDto) {
		virtualEventDetailsDto.setEventId(eventId);
		return ApiResponse.ofSuccess(virtualEventFacade.updateVirtualEventDetails(virtualEventDetailsDto), "Data Successfully Updated");
	}

	@Override
	public ApiResponse<VirtualEventDetailsDto> getVirtualEventDetailsByVirtualEventId(Integer eventId, Integer virtualEventId) {
		return ApiResponse.ofSuccess(virtualEventFacade.getVirtualEventDetailsByEventIdAndVirtualEventId(eventId, virtualEventId));
	}

}
