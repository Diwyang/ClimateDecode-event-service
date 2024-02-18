/**
 * 
 */
package com.climate.decode.eventservice.entity.transport;

import java.time.OffsetDateTime;

import com.climate.decode.eventservice.enums.FuelType;
import com.climate.decode.eventservice.enums.ModeOfTransportType;
import com.climate.decode.eventservice.enums.PeopleTravelType;
import com.climate.decode.eventservice.enums.TransportType;
import com.climate.decode.eventservice.enums.TravelDistanceType;
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
@Table(name = "transport_details")
public class TransportDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transport_id", updatable = false, nullable = false, unique = true)
	private int transportId;
	
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="transport_by")
	private PeopleTravelType transportBy;
	
	@Column(name="mode_of_transport")
	private ModeOfTransportType modeOfTransport;
	
	@Column(name="mode_of_transport_other")
	private String modeOfTransportOther;
	
	@Column(name="no_of_travellers")
	private int noOfTravellers;
	
	@Column(name="origin")
	private String origin;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="distance_travelled")
	private int distanceTravelled;
	
	@Column(name="fuel_consumption")
	private int fuelConsumption;
	
	@Column(name="fuel_type")
	private FuelType fuelType;
	
	@Column(name="fuel_type_other")
	private String fuelTypeOther;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="eventDateTime")
	private OffsetDateTime eventDateTime;
	
	@Column(name="updateDateTime")
	private OffsetDateTime updatedDateTime;
}
