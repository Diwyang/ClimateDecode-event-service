package com.climate.decode.eventservice.entity.marketing;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.climate.decode.eventservice.enums.MarketExpenditureType;
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
@Table(name = "marketing_expenditure_details")
public class MarketingExpenditureDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "marketing_id", updatable = false, nullable = false, unique = true)
	private int marketingId;
	
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="currency_used")
	private String currencyUsed;
	
	@Column(name="marketing_expenditure_type")
	private MarketExpenditureType marketingExpenditureType;
	
	@Column(name="amount")
	private BigDecimal amount;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="event_date_time")
	private OffsetDateTime eventDateTime;
	
	@Column(name="update_date_time")
	private OffsetDateTime updatedDateTime;
}
