package com.climate.decode.eventservice.dto.meal;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.climate.decode.eventservice.enums.MealType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MealDetailsDto {

	private int mealId;
	private int eventId;
	private MealType mealType;
	private int noOfMealServed;
	private String mealUnit;
	private BigDecimal perVegMealNoFoodTruck;
	private BigDecimal perVegMealWithFoodTruck;
	private int noOfFoodTruck;
	private String comments;
	private OffsetDateTime eventDateTime;
	private OffsetDateTime updatedDateTime;
}
