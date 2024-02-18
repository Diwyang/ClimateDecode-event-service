/**
 * 
 */
package com.climate.decode.eventservice.facade.eventpreparation;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.eventpreparation.EventPreparationDetailsConverter;
import com.climate.decode.eventservice.dto.eventpreparation.EventPreparationDetailsDto;
import com.climate.decode.eventservice.entity.eventpreparation.EventPreparationDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.service.eventpreparation.EventPreparationService;
import com.climate.decode.eventservice.service.information.InformationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author diwya
 *
 */

@Component
@RequiredArgsConstructor
@Slf4j
public class EventPreparationFacadeImpl implements EventPreparationFacade {

	private final EventPreparationDetailsConverter eventPreparationDetailsConverter;
	private final EventPreparationService eventPreparationService;
	private final InformationService informationService;
	
	@Override
	public EventPreparationDetailsDto createEventPreparationDetails(Integer eventId, EventPreparationDetailsDto payload) {
		log.info("EventPreparationFacadeImpl createEventPreparationDetails {}", payload);
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			payload.setEventId(eventId);
			payload.setUpdatedDateTime(OffsetDateTime.now());
			EventPreparationDetails eventPreparationDetails = eventPreparationDetailsConverter.toEntity(payload);
			return eventPreparationDetailsConverter
					.toDto(eventPreparationService.createEventPreparationData(eventPreparationDetails));
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public List<EventPreparationDetailsDto> getEventPreparationDetailsByEventId(Integer eventId) {
		log.info("EventPreparationFacadeImpl getEventPreparationDetailsByEventId  {}", eventId);
		List<EventPreparationDetailsDto> lstEventPreparationDetailsDto = new ArrayList<>();
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			List<EventPreparationDetails> lstEventPreparationDetails = eventPreparationService
					.getEventPreparationDataByEventId(eventId);
			if (lstEventPreparationDetails.size() > 0) {
				for (EventPreparationDetails eventPreparationDetail : lstEventPreparationDetails) {
					lstEventPreparationDetailsDto.add(eventPreparationDetailsConverter.toDto(eventPreparationDetail));
				}
			}
			return lstEventPreparationDetailsDto;
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public String deleteEventPreparationDetails(Integer eventId, Integer eventPreparationId) {
		log.info("EventPreparationFacadeImpl deleteEventPreparationDetails  {} {} ", eventId, eventPreparationId);
		Optional<EventPreparationDetails> eventPreparationDetails = eventPreparationService.getEventPreparationDataByEventId(eventId, eventPreparationId);
		if (eventPreparationDetails.isPresent()) {
			eventPreparationService.deleteEventPreparationData(eventId, eventPreparationId);
			return "Data deleted Successfully";
		}
		throw new ResourceNotFoundException(String.format("Record Not Found with eventId {%x} and eventPreparationId {%x}",
				eventId, eventPreparationId));
	}

	@Override
	public EventPreparationDetailsDto updateEventPreparationDetails(EventPreparationDetailsDto eventPreparationDetailsDto) {
		log.info("EventPreparationFacadeImpl updateEventPreparationDetails  {}", eventPreparationDetailsDto);
		eventPreparationDetailsDto.setUpdatedDateTime(OffsetDateTime.now());
		return eventPreparationDetailsConverter.toDto(eventPreparationService.updateEventPreparationData(eventPreparationDetailsConverter.toEntity(eventPreparationDetailsDto)));
	}

	@Override
	public EventPreparationDetailsDto getEventPreparationDetailsByEventIdAndEventPreparationId(Integer eventId,
			Integer eventPreparationId) {
		log.info("EventPreparationFacadeImpl getEventPreparationDetailsByEventId  {}", eventId);
		Optional<EventPreparationDetails> eventPreparationDetails = eventPreparationService.getEventPreparationDataByEventId(eventId, eventPreparationId);
		if (eventPreparationDetails.isPresent()) {
				return eventPreparationDetailsConverter.toDto(eventPreparationDetails.get());
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	

}
