package com.climate.decode.eventservice.dto.eventpreparation;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EventPreparationDetailsDto {

	private int eventPreparationId;
	private int eventId;
	private int noOfInPersonMeeting;
	private int noOfInPersonParticipant;
	private BigDecimal avgDistanceTraveledByParticipant;
	private int noOfOnlinePersonMeeting;
	private int noOfOnlinePersonParticipant;
	private BigDecimal avgOnlinePrepartion;
	private String comments;
	private OffsetDateTime eventDateTime;
	private OffsetDateTime updatedDateTime;
}
