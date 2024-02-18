/**
 * 
 */
package com.climate.decode.eventservice.repository.waste;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.eventservice.entity.waste.WasteDetails;

/**
 * @author diwya
 *
 */
public interface WasteDetailsRepository extends JpaRepository<WasteDetails, Long>  {

	List<WasteDetails> getByEventId(Integer eventId);

	Optional<WasteDetails> getByWasteId(Integer wasteId);

	Optional<WasteDetails> getWasteDataByEventIdAndWasteId(Integer eventId, Integer wasteId);
	
}
