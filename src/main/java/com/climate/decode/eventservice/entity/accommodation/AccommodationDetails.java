package com.climate.decode.eventservice.entity.accommodation;

import java.time.OffsetDateTime;

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
@Table(name = "accommodation_details")
public class AccommodationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "accommodation_id", updatable = false, nullable = false, unique = true)
	private int accommodationId;
	
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="person_type")
	private String personType;
	
	@Column(name="no_of_night")
	private int noOfNight;
	
	@Column(name="no_of_person")
	private int noOfPerson;
	
	@Column(name="comments")
	private String comments;

	@Column(name="eventDateTime")
	private OffsetDateTime eventDateTime;
	
	@Column(name="updateDateTime")
	private OffsetDateTime updatedDateTime;
}
