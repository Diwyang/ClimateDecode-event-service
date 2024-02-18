/**
 * 
 */
package com.climate.decode.eventservice.service.eventpreparation;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.climate.decode.eventservice.entity.eventpreparation.EventPreparationDetails;

/**
 * @author diwya
 *
 */
public interface EventPreparationService {

	public EventPreparationDetails createEventPreparationData(@RequestBody EventPreparationDetails eventPreparation);

	public List<EventPreparationDetails> getEventPreparationDataByEventId(Integer eventId);
	
	public Optional<EventPreparationDetails> getEventPreparationDataByEventId(Integer eventId, Integer eventPreparationId);

	public void deleteEventPreparationData(Integer eventId, Integer eventPreparationId);

	public EventPreparationDetails updateEventPreparationData(EventPreparationDetails eventPreparation);
}
