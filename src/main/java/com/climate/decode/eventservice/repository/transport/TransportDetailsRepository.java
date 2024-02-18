/**
 * 
 */
package com.climate.decode.eventservice.repository.transport;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.eventservice.entity.transport.TransportDetails;

/**
 * @author diwya
 *
 */
public interface TransportDetailsRepository extends JpaRepository<TransportDetails, Long>  {

	List<TransportDetails> getByEventId(Integer eventId);

	Optional<TransportDetails> getByTransportId(Integer transportId);

	Optional<TransportDetails> getTransportDetailsDataByEventIdAndTransportId(Integer eventId, Integer transportId);
	
}
