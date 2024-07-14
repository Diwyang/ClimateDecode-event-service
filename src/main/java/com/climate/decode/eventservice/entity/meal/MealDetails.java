package com.climate.decode.eventservice.entity.meal;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.climate.decode.eventservice.enums.MealType;
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
@Table(name = "meal_details")
public class MealDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "meal_id", updatable = false, nullable = false, unique = true)
	private int mealId;
	
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="meal_type")
	private MealType mealType;
	
	@Column(name="no_of_meal_served")
	private int noOfMealServed;
	
	@Column(name="meal_unit")
	private String mealUnit;
	
	@Column(name="per_veg_meal_no_food_truck")
	private BigDecimal perVegMealNoFoodTruck;
	
	@Column(name="per_veg_meal_with_food_truck")
	private BigDecimal perVegMealWithFoodTruck;
	
	@Column(name="no_of_food_truck")
	private int noOfFoodTruck;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="event_date_time")
	private OffsetDateTime eventDateTime;
	
	@Column(name="update_date_time")
	private OffsetDateTime updatedDateTime;
}
