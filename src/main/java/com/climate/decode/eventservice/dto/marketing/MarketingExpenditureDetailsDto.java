package com.climate.decode.eventservice.dto.marketing;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.climate.decode.eventservice.enums.MarketExpenditureType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MarketingExpenditureDetailsDto {

	private int marketingId;
	private int eventId;
	private String currencyUsed;
	private MarketExpenditureType marketingExpenditureType;
	private BigDecimal amount;
	private String comments;
	private OffsetDateTime eventDateTime;
	private OffsetDateTime updatedDateTime;
}
