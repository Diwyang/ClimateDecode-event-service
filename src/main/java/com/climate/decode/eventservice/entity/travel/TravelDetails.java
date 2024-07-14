/**
 * 
 */
package com.climate.decode.eventservice.entity.travel;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

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
@Table(name = "travel_details")
public class TravelDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "travel_id", updatable = false, nullable = false, unique = true)
	private int travelId;
	
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="travel_distance_type")
	private TravelDistanceType travelDistanceType;
	
	@Column(name="type_of_transport")
	private TransportType typeOfTransport;
	
	@Column(name="percentage_of_travelling")
	private BigDecimal percentageTravelling;
	
	@Column(name="people_travelling")
	private PeopleTravelType peopleTravelling;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="eventDateTime")
	private OffsetDateTime eventDateTime;
	
	@Column(name="updateDateTime")
	private OffsetDateTime updatedDateTime;
}
