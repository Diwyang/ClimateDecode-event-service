package com.climate.decode.eventservice.entity.information;

import java.time.OffsetDateTime;

import com.climate.decode.eventservice.enums.EventType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@JsonInclude(value = Include.NON_NULL)
@Table(name = "event_venue_details")
public class EventVenueDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "venue_id", updatable = false, nullable = false, unique = true)
	private int venueId;
	
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="no_of_inperson_attendees")
	private int noOfInPersonAttendees;
	
	@Column(name="no_of_virtual_attendees")
	private int noOfVirtualAttendees;
	
	@Column(name="no_of_organizer_attendees")
	private int noOfOrganizerAttendees;
	
	@Column(name="event_type")
	private String eventType;
	
	@Column(name="size_of_venue")
	private String sizeOfVenue;
	
	@Column(name="eventDateTime")
	private OffsetDateTime eventDateTime;
	
	@Column(name="updateDateTime")
	private OffsetDateTime updatedDateTime;
}
