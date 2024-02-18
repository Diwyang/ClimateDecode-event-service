package com.climate.decode.eventservice.dto.information;

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
public class EventVenueDetailsDto {

	private int venueId;
	private int eventId;
	private String sizeOfVenue;
	private String venueName;
	private OffsetDateTime eventDateTime;
	private OffsetDateTime updatedDateTime;
}
