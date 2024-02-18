/**
 * 
 */
package com.climate.decode.eventservice.dto.freightmaterial;

import java.time.OffsetDateTime;

import com.climate.decode.eventservice.enums.ModeOfTransportType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

/**
 * @author diwya
 *
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FreightMaterialDetailsDto {

	private int freightMaterialId;
	
	private int eventId;
	
	private ModeOfTransportType modeOfTransport;

	private String modeOfTransportOther;

	private double weightOfFreight;
	
	private String weightOfFreightUnit;

	private String origin;

	private String destination;

	private int distanceTravelled;
	
	private String distanceTravelledUnit;
	
	private String comments;
	
	private OffsetDateTime eventDateTime;
	
	private OffsetDateTime updatedDateTime;
}
