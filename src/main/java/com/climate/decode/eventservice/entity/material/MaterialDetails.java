/**
 * 
 */
package com.climate.decode.eventservice.entity.material;

import java.time.OffsetDateTime;

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
@Table(name = "material_details")
public class MaterialDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "material_id", updatable = false, nullable = false, unique = true)
	private int materialId;
	
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="type_of_material")
	private String typeOfMaterial;
	
	@Column(name="consumed_per_participant")
	private int consumedPerParticipant;
	
	@Column(name="unit")
	private String unit;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="eventDateTime")
	private OffsetDateTime eventDateTime;
	
	@Column(name="updateDateTime")
	private OffsetDateTime updatedDateTime;
}
