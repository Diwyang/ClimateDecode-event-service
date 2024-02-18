/**
 * 
 */
package com.climate.decode.eventservice.repository.eventpreparation;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.eventservice.entity.eventpreparation.EventPreparationDetails;

/**
 * @author diwya
 *
 */
public interface EventPreparationDetailsRepository extends JpaRepository<EventPreparationDetails, Long>  {

	List<EventPreparationDetails> getByEventId(Integer eventId);

	Optional<EventPreparationDetails> getByEventPreparationId(Integer eventPreparationId);

	Optional<EventPreparationDetails> getEventPreparationDataByEventIdAndEventPreparationId(Integer eventId, Integer eventPreparationId);
	
}
