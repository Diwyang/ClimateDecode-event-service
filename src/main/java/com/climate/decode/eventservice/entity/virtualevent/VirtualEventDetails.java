package com.climate.decode.eventservice.entity.virtualevent;

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
@Table(name = "virtual_event_details")
public class VirtualEventDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "virtual_event_id", updatable = false, nullable = false, unique = true)
	private int virtualEventId;
	
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="daily_duration")
	private int dailyDuration;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="video_streaming")
	private BigDecimal videoStreaming;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="event_date_time")
	private OffsetDateTime eventDateTime;
	
	@Column(name="update_date_time")
	private OffsetDateTime updatedDateTime;
}
