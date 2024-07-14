package com.climate.decode.eventservice.entity.eventpreparation;

import java.math.BigDecimal;
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
@Table(name = "event_preparation_details")
public class EventPreparationDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_preparation_id", updatable = false, nullable = false, unique = true)
	private int eventPreparationId;
	
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="no_of_in_person_meeting")
	private int noOfInPersonMeeting;
	
	@Column(name="no_of_in_Person_participant")
	private int noOfInPersonParticipant;
	
	@Column(name="avg_distance_traveled_by_participant")
	private BigDecimal avgDistanceTraveledByParticipant;
	
	@Column(name="no_of_online_person_meeting")
	private int noOfOnlinePersonMeeting;
	
	@Column(name="no_of_online_person_participant")
	private int noOfOnlinePersonParticipant;
	
	@Column(name="avg_online_prepartion")
	private BigDecimal avgOnlinePrepartion;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="event_date_time")
	private OffsetDateTime eventDateTime;
	
	@Column(name="update_date_time")
	private OffsetDateTime updatedDateTime;
}
