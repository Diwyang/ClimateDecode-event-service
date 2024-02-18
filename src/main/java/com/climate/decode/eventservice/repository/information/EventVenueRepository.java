package com.climate.decode.eventservice.repository.information;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.eventservice.entity.information.EventVenueDetails;

public interface EventVenueRepository extends JpaRepository<EventVenueDetails, Long> {

	List<EventVenueDetails> getByEventId(Integer eventId);

	Optional<EventVenueDetails> getByVenueId(Integer venueId);

	Optional<EventVenueDetails> getVenueDataByEventIdAndVenueId(Integer eventId, Integer venueId);
}
