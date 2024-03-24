package com.climate.decode.eventservice.entity.information;

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
@Table(name = "information_details")
public class Information {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_id", updatable = false, nullable = false, unique = true)
	private Integer eventId;
	
	@Column(name="event_type")
	private String eventType;
	
	@Column(name="event_name")
	private String eventName;
	
	@Column(name="event_organiser")
	private String eventOrganiser;
	
	@Column(name="contact_person_name")
	private String contactPersonName;
	
	@Column(name="contact_person_email")
	private String contactPersonEmail;
	
	@Column(name="event_hosted_country")
	private String eventHostedCountry;
	
	@Column(name="event_start_date")
	private OffsetDateTime eventStartDate;
	
	@Column(name="event_end_date")
	private OffsetDateTime eventEndDate;
	
	@Column(name="total_no_of_days")
	private int totalNoOfDays;
	
	@Column(name="update_date_time")
	private OffsetDateTime updatedDateTime;
	
}
