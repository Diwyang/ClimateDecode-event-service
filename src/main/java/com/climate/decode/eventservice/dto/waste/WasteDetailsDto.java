package com.climate.decode.eventservice.dto.waste;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.climate.decode.eventservice.enums.DisposalTreatmentType;
import com.climate.decode.eventservice.enums.WasteOriginType;
import com.climate.decode.eventservice.enums.WasteType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class WasteDetailsDto {

	private int wasteId;
	private int eventId;
	private WasteOriginType originType;
	private WasteType wasteType;
	private DisposalTreatmentType treatmentType;
	private BigDecimal consumption;
	private String comments;
	private OffsetDateTime eventDateTime;
	private OffsetDateTime updatedDateTime;
}
