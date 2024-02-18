/**
 * 
 */
package com.climate.decode.eventservice.facade.virtualevent;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.virtualevent.VirtualEventDetailsConverter;
import com.climate.decode.eventservice.dto.virtualevent.VirtualEventDetailsDto;
import com.climate.decode.eventservice.entity.virtualevent.VirtualEventDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.service.information.InformationService;
import com.climate.decode.eventservice.service.virtualevent.VirtualEventService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author diwya
 *
 */

@Component
@RequiredArgsConstructor
@Slf4j
public class VirtualEventFacadeImpl implements VirtualEventFacade {

	private final VirtualEventDetailsConverter virtualEventDetailsConverter;
	private final VirtualEventService virtualEventService;
	private final InformationService informationService;
	
	@Override
	public VirtualEventDetailsDto createVirtualEventDetails(Integer eventId, VirtualEventDetailsDto payload) {
		log.info("VirtualEventFacadeImpl createVirtualEventDetails {}", payload);
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			payload.setEventId(eventId);
			payload.setUpdatedDateTime(OffsetDateTime.now());
			VirtualEventDetails virtualEventDetails = virtualEventDetailsConverter.toEntity(payload);
			return virtualEventDetailsConverter
					.toDto(virtualEventService.createVirtualEventData(virtualEventDetails));
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public List<VirtualEventDetailsDto> getVirtualEventDetailsByEventId(Integer eventId) {
		log.info("VirtualEventFacadeImpl getVirtualEventDetailsByEventId  {}", eventId);
		List<VirtualEventDetailsDto> lstVirtualEventDetailsDto = new ArrayList<>();
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			List<VirtualEventDetails> lstVirtualEventDetails = virtualEventService
					.getVirtualEventDataByEventId(eventId);
			if (lstVirtualEventDetails.size() > 0) {
				for (VirtualEventDetails virtualEventDetail : lstVirtualEventDetails) {
					lstVirtualEventDetailsDto.add(virtualEventDetailsConverter.toDto(virtualEventDetail));
				}
			}
			return lstVirtualEventDetailsDto;
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public String deleteVirtualEventDetails(Integer eventId, Integer virtualEventId) {
		log.info("VirtualEventFacadeImpl deleteVirtualEventDetails  {} {} ", eventId, virtualEventId);
		Optional<VirtualEventDetails> virtualEventDetails = virtualEventService.getVirtualEventDataByEventId(eventId, virtualEventId);
		if (virtualEventDetails.isPresent()) {
			virtualEventService.deleteVirtualEventData(eventId, virtualEventId);
			return "Data deleted Successfully";
		}
		throw new ResourceNotFoundException(String.format("Record Not Found with eventId {%x} and virtualEventId {%x}",
				eventId, virtualEventId));
	}

	@Override
	public VirtualEventDetailsDto updateVirtualEventDetails(VirtualEventDetailsDto virtualEventDetailsDto) {
		log.info("VirtualEventFacadeImpl updateVirtualEventDetails  {}", virtualEventDetailsDto);
		virtualEventDetailsDto.setUpdatedDateTime(OffsetDateTime.now());
		return virtualEventDetailsConverter.toDto(virtualEventService.updateVirtualEventData(virtualEventDetailsConverter.toEntity(virtualEventDetailsDto)));
	}

	@Override
	public VirtualEventDetailsDto getVirtualEventDetailsByEventIdAndVirtualEventId(Integer eventId,
			Integer virtualEventId) {
		log.info("VirtualEventFacadeImpl getVirtualEventDetailsByEventId  {}", eventId);
		Optional<VirtualEventDetails> virtualEventDetails = virtualEventService.getVirtualEventDataByEventId(eventId, virtualEventId);
		if (virtualEventDetails.isPresent()) {
				return virtualEventDetailsConverter.toDto(virtualEventDetails.get());
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	

}
