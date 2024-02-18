/**
 * 
 */
package com.climate.decode.eventservice.service.virtualevent;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.climate.decode.eventservice.entity.virtualevent.VirtualEventDetails;

/**
 * @author diwya
 *
 */
public interface VirtualEventService {

	public VirtualEventDetails createVirtualEventData(@RequestBody VirtualEventDetails virtualEvent);

	public List<VirtualEventDetails> getVirtualEventDataByEventId(Integer eventId);
	
	public Optional<VirtualEventDetails> getVirtualEventDataByEventId(Integer eventId, Integer virtualEventId);

	public void deleteVirtualEventData(Integer eventId, Integer virtualEventId);

	public VirtualEventDetails updateVirtualEventData(VirtualEventDetails virtualEvent);
}
