package com.climate.decode.eventservice.enums;

public enum MealType {

	BREAKFAST(Names.BREAKFAST), LUNCH(Names.LUNCH), DINNER1C(Names.DINNER1C), DINNER3C(Names.DINNER3C),
	BUFFET(Names.BUFFET), DRINKS(Names.DRINKS), CANAPES(Names.CANAPES), SNACKS(Names.SNACKS), FRUIT(Names.FRUIT),
	WINE(Names.WINE), BEER(Names.BEER), SOFTDRINKS(Names.SOFTDRINKS), TEACOFFEEBREAK(Names.TEACOFFEEBREAK),
	OTHERS(Names.OTHERS);

	public static class Names {
		public static final String BREAKFAST = "Breakfast";
		public static final String LUNCH = "Lunch";
		public static final String DINNER1C = "Dinner (1-Course)";
		public static final String DINNER3C = "Dinner (3-Course)";
		public static final String BUFFET = "Buffet";
		public static final String DRINKS = "Drinks";
		public static final String CANAPES = "Canapes";
		public static final String SNACKS = "Snacks";
		public static final String FRUIT = "Fruit";
		public static final String WINE = "Wine";
		public static final String BEER = "Beer";
		public static final String SOFTDRINKS = "Soft Drinks";
		public static final String TEACOFFEEBREAK = "Tea Coffee Break";
		public static final String OTHERS = "Others";
	}

	private final String mealType;

	private MealType(String mealType) {
		this.mealType = mealType;
	}

	@Override
	public String toString() {
		return this.mealType;
	}
}
