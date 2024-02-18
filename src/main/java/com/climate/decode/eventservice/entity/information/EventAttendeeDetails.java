package com.climate.decode.eventservice.entity.information;

import java.time.OffsetDateTime;

import com.climate.decode.eventservice.enums.AttendeeType;
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
@Table(name = "event_attendee_details")
public class EventAttendeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attendee_id", updatable = false, nullable = false, unique = true)
	private int attendeeId;
	
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="no_of_atttendees")
	private int noOfAttendees;
	
	@Column(name="event_type")
	private EventType eventType;
	
	@Column(name="attendees_type")
	private AttendeeType attendeesType;
	
	@Column(name="eventDateTime")
	private OffsetDateTime eventDateTime;
	
	@Column(name="updateDateTime")
	private OffsetDateTime updatedDateTime;
}
