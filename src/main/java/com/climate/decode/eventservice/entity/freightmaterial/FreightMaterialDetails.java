/**
 * 
 */
package com.climate.decode.eventservice.entity.freightmaterial;

import java.time.OffsetDateTime;

import com.climate.decode.eventservice.enums.ModeOfFreightType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author diwya
 *
 */

@Data
@Entity
@JsonInclude(value = Include.NON_NULL)
@Table(name = "freight_material_details")
public class FreightMaterialDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "freight_material_id", updatable = false, nullable = false, unique = true)
	private int freightMaterialId;
	
	@Column(name="event_id")
	private int eventId;
		
	@Column(name="mode_of_transport")
	private ModeOfFreightType modeOfTransport;
	
	@Column(name="mode_of_transport_other")
	private String modeOfTransportOther;
	
	@Column(name="weight_of_freight")
	private double weightOfFreight;
	
	@Column(name="weight_of_freight_unit")
	private String weightOfFreightUnit;
	
	@Column(name="origin")
	private String origin;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="distance_travelled")
	private int distanceTravelled;
	
	@Column(name="distance_travelled_unit")
	private String distanceTravelledUnit;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="eventDateTime")
	private OffsetDateTime eventDateTime;
	
	@Column(name="updateDateTime")
	private OffsetDateTime updatedDateTime;
}
