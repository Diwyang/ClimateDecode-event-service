package com.climate.decode.eventservice.service.eventpreparation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.eventservice.entity.eventpreparation.EventPreparationDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.repository.eventpreparation.EventPreparationDetailsRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EventPreparationServiceImpl implements EventPreparationService {


	private final EventPreparationDetailsRepository repo;
	
	@Override
	public EventPreparationDetails createEventPreparationData(EventPreparationDetails eventPreparation) {
		return repo.save(eventPreparation);
	}

	@Override
	public List<EventPreparationDetails> getEventPreparationDataByEventId(Integer eventId) {
		return repo.getByEventId(eventId);
	}

	@Override
	public Optional<EventPreparationDetails> getEventPreparationDataByEventId(Integer eventId, Integer eventPreparationId) {
		return repo.getEventPreparationDataByEventIdAndEventPreparationId(eventId, eventPreparationId);
	}

	@Override
	public void deleteEventPreparationData(Integer eventId, Integer eventPreparationId) {
		if(repo.getEventPreparationDataByEventIdAndEventPreparationId(eventId, eventPreparationId).isPresent()) {
			repo.delete(repo.getEventPreparationDataByEventIdAndEventPreparationId(eventId, eventPreparationId).get());
		}else {
			throw new ResourceNotFoundException("Event not found with ID "+ eventId);
		}

	}

	@Override
	public EventPreparationDetails updateEventPreparationData(EventPreparationDetails eventPreparation) {
		if(repo.getEventPreparationDataByEventIdAndEventPreparationId(eventPreparation.getEventId(), eventPreparation.getEventPreparationId()).isPresent()) {
			repo.save(eventPreparation);
			return repo.getEventPreparationDataByEventIdAndEventPreparationId(eventPreparation.getEventId(), eventPreparation.getEventPreparationId()).get();
		}else {
			throw new ResourceNotFoundException(String.format("EventPreparation not found For Event ID  {} and EventPreparation ID {}", eventPreparation.getEventId(),eventPreparation.getEventPreparationId()));
		}
	}

}
