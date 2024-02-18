package com.climate.decode.eventservice.repository.information;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.eventservice.entity.information.EventAttendeeDetails;
import com.climate.decode.eventservice.entity.information.EventVenueDetails;

public interface EventAttendeesRepository extends JpaRepository<EventAttendeeDetails, Long> {

	List<EventAttendeeDetails> getByEventId(Integer eventId);

	Optional<EventAttendeeDetails> getByAttendeeId(Integer attendeeId);

	Optional<EventAttendeeDetails> getAttendeeByEventIdAndAttendeeId(Integer eventId, Integer attendeeId);
}
