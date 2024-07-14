package com.climate.decode.eventservice.dto.venue;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.climate.decode.eventservice.enums.EnergyType;
import com.climate.decode.eventservice.enums.VenueOriginType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class VenueDetailsDto {

	private int venueId;
	private int eventId;
	private EnergyType energyType;
	private BigDecimal annualConsumption;
	private String annualConsumptionUnit = "kWh";
	private BigDecimal percantageRenewableEnergy;
	private BigDecimal eventPeriodConsumption;
	private String eventPeriodConsumptionUnit = "kWh/m2";
	private BigDecimal perGuestConsumption;
	private String perGuestConsumptionUnit = "kWh/guest";
	private VenueOriginType originType;
	private int unit;
	private String fuelType;
	private String comments;
	private OffsetDateTime eventDateTime;
	private OffsetDateTime updatedDateTime;
}
