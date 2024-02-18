package com.climate.decode.eventservice.entity.venue;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.climate.decode.eventservice.enums.EnergyType;
import com.climate.decode.eventservice.enums.VenueOriginType;
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
@Table(name = "venue_details")
public class VenueDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "venue_id", updatable = false, nullable = false, unique = true)
	private int venueId;
	
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="energyType")
	private EnergyType energyType;
	
	@Column(name="annual_consumption")
	private BigDecimal annualConsumption;
	
	@Column(name="percantage_renewable_energy")
	private BigDecimal percantageRenewableEnergy;
	
	@Column(name="event_period_consumption")
	private BigDecimal eventPeriodConsumption;
	
	@Column(name="per_guest_consumption")
	private BigDecimal perGuestConsumption;
	
	@Column(name="origin_type")
	private VenueOriginType originType;
	
	@Column(name="unit")
	private int unit;
	
	@Column(name="fuel_type")
	private String fuelType;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="event_date_time")
	private OffsetDateTime eventDateTime;
	
	@Column(name="update_date_time")
	private OffsetDateTime updatedDateTime;
}
