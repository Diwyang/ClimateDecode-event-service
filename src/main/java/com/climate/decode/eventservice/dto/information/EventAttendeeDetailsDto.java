package com.climate.decode.eventservice.dto.information;

import java.time.OffsetDateTime;

import com.climate.decode.eventservice.enums.AttendeeType;
import com.climate.decode.eventservice.enums.EventType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EventAttendeeDetailsDto {

	private int attendeeId;
	private int eventId;
	private int noOfAttendees;
	private EventType eventType;
	private AttendeeType attendeesType;
	private OffsetDateTime eventDateTime;
	private OffsetDateTime updatedDateTime;
}
