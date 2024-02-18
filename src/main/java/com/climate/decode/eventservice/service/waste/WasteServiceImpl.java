package com.climate.decode.eventservice.service.waste;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.eventservice.entity.waste.WasteDetails;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.repository.waste.WasteDetailsRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class WasteServiceImpl implements WasteService {


	private final WasteDetailsRepository repo;
	
	@Override
	public WasteDetails createWasteData(WasteDetails waste) {
		return repo.save(waste);
	}

	@Override
	public List<WasteDetails> getWasteDataByEventId(Integer eventId) {
		return repo.getByEventId(eventId);
	}

	@Override
	public Optional<WasteDetails> getWasteDataByEventId(Integer eventId, Integer wasteId) {
		return repo.getWasteDataByEventIdAndWasteId(eventId, wasteId);
	}

	@Override
	public void deleteWasteData(Integer eventId, Integer wasteId) {
		if(repo.getWasteDataByEventIdAndWasteId(eventId, wasteId).isPresent()) {
			repo.delete(repo.getWasteDataByEventIdAndWasteId(eventId, wasteId).get());
		}else {
			throw new ResourceNotFoundException("Event not found with ID "+ eventId);
		}

	}

	@Override
	public WasteDetails updateWasteData(WasteDetails waste) {
		if(repo.getWasteDataByEventIdAndWasteId(waste.getEventId(), waste.getWasteId()).isPresent()) {
			repo.save(waste);
			return repo.getWasteDataByEventIdAndWasteId(waste.getEventId(), waste.getWasteId()).get();
		}else {
			throw new ResourceNotFoundException(String.format("Waste not found For Event ID  {} and Waste ID {}", waste.getEventId(),waste.getWasteId()));
		}
	}

}
