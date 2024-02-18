/**
 * 
 */
package com.climate.decode.eventservice.facade.transport;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.climate.decode.eventservice.converter.transport.TransportDetailsConverter;
import com.climate.decode.eventservice.dto.transport.TransportDetailsDto;
import com.climate.decode.eventservice.entity.transport.TransportDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.service.information.InformationService;
import com.climate.decode.eventservice.service.transport.TransportService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author diwya
 *
 */

@Component
@RequiredArgsConstructor
@Slf4j
public class TransportDetailsFacadeImpl implements TransportDetailsFacade {

	private final TransportDetailsConverter transportDetailsConverter;
	private final TransportService transportService;
	private final InformationService informationService;
	
	@Override
	public TransportDetailsDto createTransportDetails(Integer eventId, TransportDetailsDto payload) {
		log.info("AccommodationFacadeImpl createTransportDetails {}", payload);
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			payload.setEventId(eventId);
			payload.setUpdatedDateTime(OffsetDateTime.now());
			TransportDetails transportDetails = transportDetailsConverter.toEntity(payload);
			return transportDetailsConverter
					.toDto(transportService.createTransportDetailsData(transportDetails));
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public List<TransportDetailsDto> getTransportDetailsByEventId(Integer eventId) {
		log.info("AccommodationFacadeImpl getTransportDetailsByEventId  {}", eventId);
		List<TransportDetailsDto> lstTransportDetailsDto = new ArrayList<>();
		if (!informationService.getInformationByEventId(eventId).isEmpty()) {
			List<TransportDetails> lstTransportDetails = transportService
					.getTransportDetailsDataByEventId(eventId);
			if (lstTransportDetails.size() > 0) {
				for (TransportDetails accommodationDetail : lstTransportDetails) {
					lstTransportDetailsDto.add(transportDetailsConverter.toDto(accommodationDetail));
				}
			}
			return lstTransportDetailsDto;
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	@Override
	public String deleteTransportDetails(Integer eventId, Integer transportId) {
		log.info("AccommodationFacadeImpl deleteTransportDetails  {} {} ", eventId, transportId);
		Optional<TransportDetails> transportDetails = transportService.getTransportDetailsDataByEventIdAndTransportId(eventId, transportId);
		if (transportDetails.isPresent()) {
			transportService.deleteTransportDetailsData(eventId, transportId);
			return "Data deleted Successfully";
		}
		throw new ResourceNotFoundException(String.format("Record Not Found with eventId {%x} and accommodationId {%x}",
				eventId, transportId));
	}

	@Override
	public TransportDetailsDto updateTransportDetails(TransportDetailsDto transportDetailsDto) {
		log.info("AccommodationFacadeImpl updateTransportDetails  {}", transportDetailsDto);
		transportDetailsDto.setUpdatedDateTime(OffsetDateTime.now());
		return transportDetailsConverter.toDto(transportService.updateTransportDetailsData(transportDetailsConverter.toEntity(transportDetailsDto)));
	}

	@Override
	public TransportDetailsDto getTransportDetailsByEventIdAndTransportId(Integer eventId,
			Integer transportId) {
		log.info("AccommodationFacadeImpl getTransportDetailsByEventId  {}", eventId);
		Optional<TransportDetails> transportDetails = transportService.getTransportDetailsDataByEventIdAndTransportId(eventId, transportId);
		if (transportDetails.isPresent()) {
				return transportDetailsConverter.toDto(transportDetails.get());
		}
		throw new ResourceNotFoundException("Invalid Event Id " + eventId);
	}

	

}
