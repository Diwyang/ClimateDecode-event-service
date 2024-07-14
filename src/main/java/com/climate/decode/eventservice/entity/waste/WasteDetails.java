package com.climate.decode.eventservice.entity.waste;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.climate.decode.eventservice.enums.DisposalTreatmentType;
import com.climate.decode.eventservice.enums.WasteOriginType;
import com.climate.decode.eventservice.enums.WasteType;
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
@Table(name = "waste_details")
public class WasteDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "waste_id", updatable = false, nullable = false, unique = true)
	private int wasteId;
	
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="origin_type")
	private WasteOriginType originType;
	
	@Column(name="waste_type")
	private WasteType wasteType;
	
	@Column(name="treatment_type")
	private DisposalTreatmentType treatmentType;
	
	@Column(name="consumption")
	private BigDecimal consumption;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="event_date_time")
	private OffsetDateTime eventDateTime;
	
	@Column(name="update_date_time")
	private OffsetDateTime updatedDateTime;
}
