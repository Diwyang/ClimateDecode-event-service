package com.climate.decode.eventservice.service.information;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.climate.decode.eventservice.entity.information.EventAttendeeDetails;
import com.climate.decode.eventservice.entity.information.EventVenueDetails;
import com.climate.decode.eventservice.entity.information.Information;

public interface InformationService {

	public Information createInformationData(@RequestBody Information information);

	public Optional<Information> getInformationByEventId(Integer eventId);

	public void deleteInformationData(Integer eventId);

	public Information updateInformationData(Information information);

	public EventVenueDetails createVenueData(EventVenueDetails eventVenueDetails);

	public List<EventVenueDetails> getVenueDataByEventId(Integer eventId);
	
	public Optional<EventVenueDetails> getVenueDataByVenueId(Integer venueId);

	public void deleteVenueData(EventVenueDetails eventVenueDetails);

	public EventVenueDetails updateVenueData(@RequestBody EventVenueDetails eventVenueDetails);

	public EventAttendeeDetails createAttendeeData(@RequestBody EventAttendeeDetails eventAttendeeDetails);

	public List<EventAttendeeDetails> getAttendeeDataByEventId(Integer eventId);
	
	public Optional<EventAttendeeDetails> getAttendeeDataByAttendeeId(Integer attendeeId);

	public void deleteAttendeeData(EventAttendeeDetails eventAttendeeDetails);

	public EventAttendeeDetails updateAttendeeData(@RequestBody EventAttendeeDetails eventAttendeeDetails);
	
	public List<Information> getInformationDetails();
	
	public Optional<EventVenueDetails> getVenueDataByEventIdAndVenueId(Integer eventId, Integer venueId);
	
	public Optional<EventAttendeeDetails> getAttendeeDataByEventIdAndAttendeeId(Integer eventId, Integer attendeeId);
}
