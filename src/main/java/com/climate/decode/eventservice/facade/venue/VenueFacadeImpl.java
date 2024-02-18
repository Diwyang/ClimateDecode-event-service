/**
 * 
 */
package com.climate.decode.eventservice.facade.venue;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.venue.VenueDetailsConverter;
import com.climate.decode.eventservice.dto.venue.VenueDetailsDto;
import com.climate.decode.eventservice.entity.venue.VenueDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.service.venue.VenueService;
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
public class VenueFacadeImpl implements VenueFacade {

	private final VenueDetailsConverter venueDetailsConverter;
	private final VenueService venueService;
	private final InformationService informationService;
	
	@Override
	public VenueDetailsDto createVenueDetails(Integer eventId, VenueDetailsDto payload) {
		log.info("VenueFacadeImpl createVenueDetails {}", payload);
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			payload.setEventId(eventId);
			payload.setUpdatedDateTime(OffsetDateTime.now());
			VenueDetails venueDetails = venueDetailsConverter.toEntity(payload);
			return venueDetailsConverter
					.toDto(venueService.createVenueData(venueDetails));
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public List<VenueDetailsDto> getVenueDetailsByEventId(Integer eventId) {
		log.info("VenueFacadeImpl getVenueDetailsByEventId  {}", eventId);
		List<VenueDetailsDto> lstVenueDetailsDto = new ArrayList<>();
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			List<VenueDetails> lstVenueDetails = venueService
					.getVenueDataByEventId(eventId);
			if (lstVenueDetails.size() > 0) {
				for (VenueDetails venueDetail : lstVenueDetails) {
					lstVenueDetailsDto.add(venueDetailsConverter.toDto(venueDetail));
				}
			}
			return lstVenueDetailsDto;
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public String deleteVenueDetails(Integer eventId, Integer venueId) {
		log.info("VenueFacadeImpl deleteVenueDetails  {} {} ", eventId, venueId);
		Optional<VenueDetails> venueDetails = venueService.getVenueDataByEventId(eventId, venueId);
		if (venueDetails.isPresent()) {
			venueService.deleteVenueData(eventId, venueId);
			return "Data deleted Successfully";
		}
		throw new ResourceNotFoundException(String.format("Record Not Found with eventId {%x} and venueId {%x}",
				eventId, venueId));
	}

	@Override
	public VenueDetailsDto updateVenueDetails(VenueDetailsDto venueDetailsDto) {
		log.info("VenueFacadeImpl updateVenueDetails  {}", venueDetailsDto);
		venueDetailsDto.setUpdatedDateTime(OffsetDateTime.now());
		return venueDetailsConverter.toDto(venueService.updateVenueData(venueDetailsConverter.toEntity(venueDetailsDto)));
	}

	@Override
	public VenueDetailsDto getVenueDetailsByEventIdAndVenueId(Integer eventId,
			Integer venueId) {
		log.info("VenueFacadeImpl getVenueDetailsByEventId  {}", eventId);
		Optional<VenueDetails> venueDetails = venueService.getVenueDataByEventId(eventId, venueId);
		if (venueDetails.isPresent()) {
				return venueDetailsConverter.toDto(venueDetails.get());
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	

}
