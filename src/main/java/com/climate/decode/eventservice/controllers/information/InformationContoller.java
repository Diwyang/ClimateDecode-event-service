package com.climate.decode.eventservice.controllers.information;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.climate.decode.eventservice.api.information.InformationApi;
import com.climate.decode.eventservice.dto.information.EventVenueDetailsDto;
import com.climate.decode.eventservice.dto.information.InformationDto;
import com.climate.decode.eventservice.facade.information.InformationFacade;
import com.climate.decode.eventservice.response.ApiResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class InformationContoller implements InformationApi {

	private final InformationFacade informationFacade;
	
	@Override
	public ApiResponse<InformationDto> createInformationData(InformationDto informationDto) {
		return ApiResponse.ofSuccess(informationFacade.createInformationData(informationDto),"Data save successfully");
	}

	@Override
	public ApiResponse<InformationDto> getInformationByEventId(Integer eventId) {
		return ApiResponse.ofSuccess(informationFacade.getInformationByEventId(eventId));
	}

	@Override
	public ApiResponse<List<InformationDto>> getInformationDetails() {
		return ApiResponse.ofSuccess(informationFacade.getInformationDetails());
	}
	
	@Override
	public ApiResponse<List<InformationDto>> getInformationDetailsByOrg(Integer orgId) {
		return ApiResponse.ofSuccess(informationFacade.getInformationDetailsByOrg(orgId));
	}
	
	@Override
	public ApiResponse<String> deleteInformationData(Integer eventId) {
		return ApiResponse.ofSuccess(informationFacade.deleteInformationData(eventId),"Data Deleted Successfully");
	}

	@Override
	public ApiResponse<InformationDto> updateInformationData(InformationDto informationDto) {
		return ApiResponse.ofSuccess(informationFacade.updateInformationData(informationDto),"Data Successfully Updated");
	}

	@Override
	public ApiResponse<EventVenueDetailsDto> createVenueData(Integer eventId, EventVenueDetailsDto eventVenueDetailsDto) {
		return ApiResponse.ofSuccess(informationFacade.createVenueData(eventId,eventVenueDetailsDto),"Data save successfully");
	}

	@Override
	public ApiResponse<List<EventVenueDetailsDto>> getVenueDataByEventId(Integer eventId) {
		return ApiResponse.ofSuccess(informationFacade.getVenueDataByEventId(eventId));
	}

	@Override
	public ApiResponse<String> deleteVenueData(Integer eventId, Integer venueId) {
		return ApiResponse.ofSuccess(informationFacade.deleteVenueData(eventId, venueId),"Data Deleted Successfully");
	}

	@Override
	public ApiResponse<EventVenueDetailsDto> updateVenueData(Integer eventId, EventVenueDetailsDto eventVenueDetailsDto) {
		return ApiResponse.ofSuccess(informationFacade.updateVenueData(eventId, eventVenueDetailsDto),"Data Successfully Updated");
	}

	@Override
	public ApiResponse<EventVenueDetailsDto> getVenueDataByEventIdAndVenueId(Integer eventId, Integer venueId) {
		return ApiResponse.ofSuccess(informationFacade.getVenueDataByEventIdAndVenueId(eventId, venueId));
	}

}
