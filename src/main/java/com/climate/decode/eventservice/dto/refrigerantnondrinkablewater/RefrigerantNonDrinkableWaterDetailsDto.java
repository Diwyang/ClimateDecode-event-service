package com.climate.decode.eventservice.dto.refrigerantnondrinkablewater;

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
public class RefrigerantNonDrinkableWaterDetailsDto {

	private int refNonDrinkableId;
	private int eventId;
	private int noOfWindows;
	private BigDecimal ceilingHeight;
	private BigDecimal volumeOfNonDrinkableWater;
	private String comments;
	private OffsetDateTime eventDateTime;
	private OffsetDateTime updatedDateTime;
}
