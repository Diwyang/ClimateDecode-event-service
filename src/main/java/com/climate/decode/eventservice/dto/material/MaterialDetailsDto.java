/**
 * 
 */
package com.climate.decode.eventservice.dto.material;

import java.time.OffsetDateTime;

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
public class MaterialDetailsDto {

	private int materialId;
	
	private int eventId;
	
	private String typeOfMaterial;
	
	private int consumedPerParticipant;
	
	private String unit;
	
	private String comments;
	
	private OffsetDateTime eventDateTime;
	
	private OffsetDateTime updatedDateTime;
}
