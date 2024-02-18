package com.climate.decode.eventservice.service.virtualevent;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.eventservice.entity.virtualevent.VirtualEventDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.repository.virtualevent.VirtualEventDetailsRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VirtualEventServiceImpl implements VirtualEventService {


	private final VirtualEventDetailsRepository repo;
	
	@Override
	public VirtualEventDetails createVirtualEventData(VirtualEventDetails virtualEvent) {
		return repo.save(virtualEvent);
	}

	@Override
	public List<VirtualEventDetails> getVirtualEventDataByEventId(Integer eventId) {
		return repo.getByEventId(eventId);
	}

	@Override
	public Optional<VirtualEventDetails> getVirtualEventDataByEventId(Integer eventId, Integer virtualEventId) {
		return repo.getVirtualEventDataByEventIdAndVirtualEventId(eventId, virtualEventId);
	}

	@Override
	public void deleteVirtualEventData(Integer eventId, Integer virtualEventId) {
		if(repo.getVirtualEventDataByEventIdAndVirtualEventId(eventId, virtualEventId).isPresent()) {
			repo.delete(repo.getVirtualEventDataByEventIdAndVirtualEventId(eventId, virtualEventId).get());
		}else {
			throw new ResourceNotFoundException("Event not found with ID "+ eventId);
		}

	}

	@Override
	public VirtualEventDetails updateVirtualEventData(VirtualEventDetails virtualEvent) {
		if(repo.getVirtualEventDataByEventIdAndVirtualEventId(virtualEvent.getEventId(), virtualEvent.getVirtualEventId()).isPresent()) {
			repo.save(virtualEvent);
			return repo.getVirtualEventDataByEventIdAndVirtualEventId(virtualEvent.getEventId(), virtualEvent.getVirtualEventId()).get();
		}else {
			throw new ResourceNotFoundException(String.format("VirtualEvent not found For Event ID  {} and VirtualEvent ID {}", virtualEvent.getEventId(),virtualEvent.getVirtualEventId()));
		}
	}

}
