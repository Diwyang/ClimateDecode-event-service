package com.climate.decode.eventservice.service.information;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.eventservice.entity.information.EventVenueDetails;
import com.climate.decode.eventservice.entity.information.Information;
import com.climate.decode.eventservice.exception.ResourceNotFoundException;
import com.climate.decode.eventservice.repository.information.EventVenueRepository;
import com.climate.decode.eventservice.repository.information.InformationRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InformationServiceImpl implements InformationService {

	private final InformationRepository informationRepo;
	private final EventVenueRepository eventVenueRepo;
	
	@Override
	public Information createInformationData(Information information) {
		return informationRepo.save(information);
	}

	@Override
	public Optional<Information> getInformationByEventId(Integer eventId) {
		return informationRepo.getByEventId(eventId);
	}

	@Override
	public void deleteInformationData(Integer eventId) {
		if(informationRepo.getByEventId(eventId).isPresent()) {
			informationRepo.delete(informationRepo.getByEventId(eventId).get());
		}else {
			throw new ResourceNotFoundException("Event not found with ID "+ eventId);
		}
	}

	@Override
	public Information updateInformationData(Information information) {
		if (informationRepo.getByEventId(Integer.valueOf(information.getEventId().toString())).isPresent()) {
			informationRepo.save(information);
			return informationRepo.getByEventId(Integer.valueOf(information.getEventId().toString())).get();
		} else {
			throw new ResourceNotFoundException("Event not found with ID " + information.getEventId());
		}
	}

	@Override
	public EventVenueDetails createVenueData(EventVenueDetails eventVenueDetails) {
		return eventVenueRepo.save(eventVenueDetails);
	}

	@Override
	public List<EventVenueDetails> getVenueDataByEventId(Integer eventId) {
		return eventVenueRepo.getByEventId(eventId);
	}

	@Override
	public void deleteVenueData(EventVenueDetails eventVenueDetails) {
		eventVenueRepo.delete(eventVenueDetails);
	}


	@Override
	public Optional<EventVenueDetails> getVenueDataByVenueId(Integer venueId) {
		return eventVenueRepo.getByVenueId(venueId);
	}

	@Override
	public List<Information> getInformationDetails() {
		return informationRepo.findAll();
	}

	@Override
	public Optional<EventVenueDetails> getVenueDataByEventIdAndVenueId(Integer eventId, Integer venueId) {
		return eventVenueRepo.getVenueDataByEventIdAndVenueId(eventId, venueId);
	}

	@Override
	public EventVenueDetails updateVenueData(EventVenueDetails eventVenueDetails) {
		if (eventVenueRepo.getByVenueId(eventVenueDetails.getVenueId()).isPresent()) {
			eventVenueRepo.save(eventVenueDetails);
			return eventVenueRepo.getByVenueId(eventVenueDetails.getVenueId()).get();
		} else {
			throw new ResourceNotFoundException("Venue not found with ID " + eventVenueDetails.getVenueId());
		}
	}
	

	@Override
	public List<Information> getInformationDetailsByOrg(Integer orgId) {
		return informationRepo.getByOrgId(orgId);
	}
}
