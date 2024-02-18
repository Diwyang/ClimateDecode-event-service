package com.climate.decode.eventservice.facade.information;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.information.EventAttendeeDetailConverter;
import com.climate.decode.eventservice.converter.information.EventVenueDataConverter;
import com.climate.decode.eventservice.converter.information.InformationConverter;
import com.climate.decode.eventservice.dto.information.EventAttendeeDetailsDto;
import com.climate.decode.eventservice.dto.information.EventVenueDetailsDto;
import com.climate.decode.eventservice.dto.information.InformationDto;
import com.climate.decode.eventservice.entity.information.EventAttendeeDetails;
import com.climate.decode.eventservice.entity.information.EventVenueDetails;
import com.climate.decode.eventservice.entity.information.Information;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.service.information.InformationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class InformationFacadeImpl implements InformationFacade {

	private final InformationService informationService;
	private final InformationConverter informationConverter;
	private final EventVenueDataConverter eventVenueDataConverter;
	private final EventAttendeeDetailConverter eventAttendeeDetailsConverter;
	
	@Override
	public InformationDto createInformationData(InformationDto payload) {
		log.info("InformationFacadeImpl createInformationData {}", payload);
		payload.setUpdatedDateTime(OffsetDateTime.now());
		Information information= informationConverter.toEntity(payload);
		return informationConverter.toDto(informationService.createInformationData(information));
	}

	@Override
	public InformationDto getInformationByEventId(Integer eventId) {
		log.info("InformationFacadeImpl getInformationByEventId  {}", eventId);
		Optional<Information> information = informationService.getInformationByEventId(eventId);
		if(!information.isEmpty()) {
			return informationConverter.toDto(information.get());
		} else {
			throw new ResourceNotFoundException("Invalid Event Id "+eventId);
		}
	}

	@Override
	public String deleteInformationData(Integer eventId) {
		log.info("InformationFacadeImpl deleteInformationData");
		
		return null;
	}

	@Override
	public InformationDto updateInformationData(InformationDto informationDto) {
		log.info("InformationFacadeImpl updateInformationData {} ", informationDto);
		informationDto.setUpdatedDateTime(OffsetDateTime.now());
		return informationConverter.toDto(informationService.updateInformationData(informationConverter.toEntity(informationDto)));
	}

	@Override
	public EventVenueDetailsDto createVenueData(Integer eventId, EventVenueDetailsDto payload) {
		log.info("InformationFacadeImpl createVenueData {}", payload);
		if (informationService.getInformationByEventId(eventId).isPresent()) {
			payload.setEventId(eventId);
			payload.setUpdatedDateTime(OffsetDateTime.now());
			EventVenueDetails eventVenueDetails = eventVenueDataConverter.toEntity(payload);
			return eventVenueDataConverter.toDto(informationService.createVenueData(eventVenueDetails));
		}
		throw new ResourceNotFoundException("Invalid Event Id "+eventId);
	}

	@Override
	public List<EventVenueDetailsDto> getVenueDataByEventId(Integer eventId) {
		log.info("InformationFacadeImpl getVenueDataByEventId  {}", eventId);
		List<EventVenueDetailsDto> lstEventVenueDetailsDto = new ArrayList<>();
		if (informationService.getInformationByEventId(eventId).isPresent()) {
			List<EventVenueDetails> lstEventVenueDetail = informationService.getVenueDataByEventId(eventId);
			for (EventVenueDetails eventVenueDetail : lstEventVenueDetail) {
				lstEventVenueDetailsDto.add(eventVenueDataConverter.toDto(eventVenueDetail));
			}
			return lstEventVenueDetailsDto;
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public String deleteVenueData(Integer eventId, Integer venueId) {
		log.info("InformationFacadeImpl deleteVenueData");
		Optional<EventVenueDetails> eventVenueDetails = informationService.getVenueDataByEventIdAndVenueId(eventId, venueId);
		if(!eventVenueDetails.isEmpty()) {
			informationService.deleteVenueData(eventVenueDetails.get());
			return "Data deleted Successfully";
		}
		throw new ResourceNotFoundException(String.format("Record Not Found with eventId {} and venueId {}", eventId.toString(), venueId.toString()));
	}

	@Override
	public EventVenueDetailsDto updateVenueData(Integer eventId, EventVenueDetailsDto eventVenueDetailsDto) {
		log.info("InformationFacadeImpl updateVenueData {} ", eventVenueDetailsDto);
		eventVenueDetailsDto.setUpdatedDateTime(OffsetDateTime.now());
		return eventVenueDataConverter.toDto(informationService.updateVenueData(eventVenueDataConverter.toEntity(eventVenueDetailsDto)));
	}

	@Override
	public EventAttendeeDetailsDto createAttendeeData(Integer eventId, EventAttendeeDetailsDto payload) {
		log.info("InformationFacadeImpl createAttendeeData {}", payload);
		if (informationService.getInformationByEventId(eventId).isPresent()) {
			payload.setEventId(eventId);
			payload.setUpdatedDateTime(OffsetDateTime.now());
			EventAttendeeDetails eventAttendeeDetails = eventAttendeeDetailsConverter.toEntity(payload);
			return eventAttendeeDetailsConverter.toDto(informationService.createAttendeeData(eventAttendeeDetails));
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public List<EventAttendeeDetailsDto> getAttendeeDataByEventId(Integer attendeeId) {
		log.info("InformationFacadeImpl getAttendeeDataByEventId  {}", attendeeId);
		List<EventAttendeeDetailsDto> lstEventAttendeeDetailsDto = new ArrayList<>();
		List<EventAttendeeDetails> lstEventAttendeeDetail = informationService.getAttendeeDataByEventId(attendeeId);
		for(EventAttendeeDetails eventAttendeeDetail : lstEventAttendeeDetail) {
			lstEventAttendeeDetailsDto.add(eventAttendeeDetailsConverter.toDto(eventAttendeeDetail));
		}
		return lstEventAttendeeDetailsDto;
	}

	@Override
	public String deleteAttendeeData(Integer eventId, Integer attendeeId) {
		log.info("InformationFacadeImpl deleteAttendeeData");
		Optional<EventAttendeeDetails> eventAttendeeDetails = informationService.getAttendeeDataByEventIdAndAttendeeId(eventId, attendeeId);
		if(!eventAttendeeDetails.isEmpty()) {
			informationService.deleteAttendeeData(eventAttendeeDetails.get());
			return "Data deleted Successfully";
		}
		
		throw new ResourceNotFoundException(String.format("Record Not Found with eventId {} and attendeeId {}", eventId.toString(), attendeeId.toString()));
	}

	@Override
	public EventAttendeeDetailsDto updateAttendeeData(Integer eventId, EventAttendeeDetailsDto eventAttendeeDetailsDto) {
		log.info("InformationFacadeImpl updateAttendeeData {} ", eventAttendeeDetailsDto);
		eventAttendeeDetailsDto.setUpdatedDateTime(OffsetDateTime.now());
		return eventAttendeeDetailsConverter.toDto(informationService.updateAttendeeData(eventAttendeeDetailsConverter.toEntity(eventAttendeeDetailsDto)));
	}

	@Override
	public List<InformationDto> getInformationDetails() {
		log.info("InformationFacadeImpl getInformationDetails");
		List<InformationDto> lstInformationDto = new ArrayList<>();
		List<Information> lstInformation = informationService.getInformationDetails();
		for (Information information : lstInformation) {
			lstInformationDto.add(informationConverter.toDto(information));
		}
		return lstInformationDto;
	}

	@Override
	public EventVenueDetailsDto getVenueDataByEventIdAndVenueId(Integer eventId, Integer venueId) {
		log.info("InformationFacadeImpl getVenueDataByEventIdAndVenueId");
		if(!informationService.getVenueDataByEventIdAndVenueId(eventId, venueId).isEmpty()) {
			return eventVenueDataConverter.toDto(informationService.getVenueDataByEventIdAndVenueId(eventId, venueId).get());
		}
		throw new ResourceNotFoundException(String.format("Record Not Found with eventId {} and venueId {}", eventId.toString(), venueId.toString()));
	}

	@Override
	public EventAttendeeDetailsDto getAttendeeDataByEventIdAndAttendeeId(Integer eventId, Integer attendeeId) {
		log.info("InformationFacadeImpl getAttendeeDataByEventIdAndAttendeeId");
		if(!informationService.getAttendeeDataByEventIdAndAttendeeId(eventId, attendeeId).isEmpty()) {
			return eventAttendeeDetailsConverter.toDto(informationService.getAttendeeDataByEventIdAndAttendeeId(eventId, attendeeId).get());
		}
		throw new ResourceNotFoundException(String.format("Record Not Found with eventId {} and attendeeId {}", eventId.toString(), attendeeId.toString()));
	}

}