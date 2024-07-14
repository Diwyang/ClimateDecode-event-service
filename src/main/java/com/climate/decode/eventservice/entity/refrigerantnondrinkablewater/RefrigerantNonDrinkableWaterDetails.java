package com.climate.decode.eventservice.entity.refrigerantnondrinkablewater;

import java.math.BigDecimal;
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

@Data
@Entity
@JsonInclude(value = Include.NON_NULL)
@Table(name = "refrigerant_non_drinkable_details")
public class RefrigerantNonDrinkableWaterDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ref_non_drinkable_id", updatable = false, nullable = false, unique = true)
	private int refNonDrinkableId;
	
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="no_of_windows")
	private int noOfWindows;
	
	@Column(name="ceiling_height")
	private BigDecimal ceilingHeight;
	
	@Column(name="vol_of_non_drinkable_water")
	private BigDecimal volumeOfNonDrinkableWater;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="event_date_time")
	private OffsetDateTime eventDateTime;
	
	@Column(name="update_date_time")
	private OffsetDateTime updatedDateTime;
}
