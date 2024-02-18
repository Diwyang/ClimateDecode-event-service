package com.climate.decode.eventservice.facade.information;

import java.util.List;

import com.climate.decode.eventservice.dto.information.EventAttendeeDetailsDto;
import com.climate.decode.eventservice.dto.information.EventVenueDetailsDto;
import com.climate.decode.eventservice.dto.information.InformationDto;
import com.climate.decode.eventservice.response.ApiResponse;

public interface InformationFacade {

	public InformationDto createInformationData(InformationDto informationDto);

	public InformationDto getInformationByEventId(Integer eventId);
	
	public List<InformationDto> getInformationDetails();

	public String deleteInformationData(Integer eventId);

	public InformationDto updateInformationData(InformationDto informationDto);

	public EventVenueDetailsDto createVenueData(Integer eventId, EventVenueDetailsDto eventVenueDetailsDto);

	public List<EventVenueDetailsDto> getVenueDataByEventId(Integer venueId);
	
	public EventVenueDetailsDto getVenueDataByEventIdAndVenueId(Integer eventId, Integer venueId);

	public String deleteVenueData(Integer eventId, Integer venueId);

	public EventVenueDetailsDto updateVenueData(Integer eventId, EventVenueDetailsDto eventVenueDetailsDto);

	public EventAttendeeDetailsDto createAttendeeData(Integer eventId, EventAttendeeDetailsDto eventAttendeeDetailsDto);

	public List<EventAttendeeDetailsDto> getAttendeeDataByEventId(Integer attendeeId);
	
	public EventAttendeeDetailsDto getAttendeeDataByEventIdAndAttendeeId(Integer eventId, Integer attendeeId);

	public String deleteAttendeeData(Integer eventId, Integer attendeeId);

	public EventAttendeeDetailsDto updateAttendeeData(Integer eventId, EventAttendeeDetailsDto eventAttendeeDetailsDto);
}
