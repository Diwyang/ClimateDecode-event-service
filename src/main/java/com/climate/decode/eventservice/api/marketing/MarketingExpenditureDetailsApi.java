package com.climate.decode.eventservice.api.marketing;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.climate.decode.eventservice.dto.marketing.MarketingExpenditureDetailsDto;
import com.climate.decode.eventservice.response.ApiResponse;

@RequestMapping("/events/{eventId}/marketing-expenditure-details")
public interface MarketingExpenditureDetailsApi {

	@PostMapping("")
	public ApiResponse<MarketingExpenditureDetailsDto> createMarketingExpenditureDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody MarketingExpenditureDetailsDto marketingExpenditureDetailsDto);
	
	@GetMapping("")
	public ApiResponse<List<MarketingExpenditureDetailsDto>> getMarketingExpenditureDetailsByEventId(@PathVariable(value = "eventId") Integer eventId);
	
	@GetMapping("/{marketingExpenditureId}")
	public ApiResponse<MarketingExpenditureDetailsDto> getMarketingExpenditureDetailsByMarketingExpenditureId(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "marketingExpenditureId") Integer marketingExpenditureId);

	
	@DeleteMapping("/{marketingExpenditureId}")
	public ApiResponse<String> deleteMarketingExpenditureDetails(@PathVariable(value = "eventId") Integer eventId, @PathVariable(value = "marketingExpenditureId") Integer marketingExpenditureId);
	
	@PatchMapping("")
	public ApiResponse<MarketingExpenditureDetailsDto> updateMarketingExpenditureDetails(@PathVariable(value = "eventId") Integer eventId, @RequestBody MarketingExpenditureDetailsDto marketingExpenditureDetailsDto);
	
}
