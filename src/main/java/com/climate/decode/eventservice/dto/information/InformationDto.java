package com.climate.decode.eventservice.dto.information;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class InformationDto {
	
	private int eventId;
	private String eventType;
	private String eventName;
	private String eventOrganiser;
	private String contactPersonName;
	private String contactPersonEmail;
	private String eventHostedCountry;
	private OffsetDateTime eventStartDate;
	private OffsetDateTime eventEndDate;
	private int totalNoOfDays;
	private OffsetDateTime updatedDateTime;
	private List<EventVenueDetailsDto> venueDetailList = new ArrayList<>();
}
