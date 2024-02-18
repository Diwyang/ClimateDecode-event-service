/**
 * 
 */
package com.climate.decode.eventservice.service.transport;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.eventservice.entity.transport.TransportDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.repository.transport.TransportDetailsRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author diwya
 *
 */

@RequiredArgsConstructor
@Service
public class TransportServiceImpl implements TransportService {

	private final TransportDetailsRepository repo;
	
	@Override
	public TransportDetails createTransportDetailsData(TransportDetails transportDetail) {
		return repo.save(transportDetail);
	}

	@Override
	public List<TransportDetails> getTransportDetailsDataByEventId(Integer eventId) {
		return repo.getByEventId(eventId);
	}

	@Override
	public Optional<TransportDetails> getTransportDetailsDataByEventIdAndTransportId(Integer eventId, Integer transportID) {
		return repo.getTransportDetailsDataByEventIdAndTransportId(eventId, transportID);
	}

	@Override
	public void deleteTransportDetailsData(Integer eventId, Integer transportId ) {
		if(repo.getTransportDetailsDataByEventIdAndTransportId(eventId, transportId).isPresent()) {
			repo.delete(repo.getTransportDetailsDataByEventIdAndTransportId(eventId, transportId).get());
		}else {
			throw new ResourceNotFoundException("Event not found with ID "+ eventId);
		}
	}

	@Override
	public TransportDetails updateTransportDetailsData(TransportDetails transportDetail) {
		if(repo.getTransportDetailsDataByEventIdAndTransportId(transportDetail.getEventId(), transportDetail.getTransportId()).isPresent()) {
			repo.save(transportDetail);
			return repo.getTransportDetailsDataByEventIdAndTransportId(transportDetail.getEventId(), transportDetail.getTransportId()).get();
		}else {
			throw new ResourceNotFoundException("Event not found with ID "+ transportDetail.getEventId());
		}
	}

}
