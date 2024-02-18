/**
 * 
 */
package com.climate.decode.eventservice.facade.virtualevent;

import java.util.List;

import com.climate.decode.eventservice.dto.virtualevent.VirtualEventDetailsDto;


/**
 * @author diwya
 *
 */
public interface VirtualEventFacade {

	public VirtualEventDetailsDto createVirtualEventDetails(Integer eventId, VirtualEventDetailsDto virtualEventDetailsDto);

	public List<VirtualEventDetailsDto> getVirtualEventDetailsByEventId(Integer eventId);
	
	public VirtualEventDetailsDto getVirtualEventDetailsByEventIdAndVirtualEventId(Integer eventId, Integer virtualEventId);

	public String deleteVirtualEventDetails(Integer eventId, Integer virtualEventId);

	public VirtualEventDetailsDto updateVirtualEventDetails(VirtualEventDetailsDto virtualEventDetailsDto);
}
