package com.climate.decode.eventservice.enums;

public enum ModeOfFreightType {

	VAN(Names.VAN),LIGHTTRUCK(Names.LIGHTTRUCK), HEAVYTRUCK(Names.HEAVYTRUCK),
	HEAVYTRUCKTRAILER(Names.HEAVYTRUCKTRAILER),CARGOSHIP(Names.CARGOSHIP), TRAIN(Names.TRAIN), FLIGHT(Names.FLIGHT),
	OTHER(Names.OTHER);

	public static class Names {
		public static final String VAN = "Van";
		public static final String LIGHTTRUCK = "Light Truck";
		public static final String HEAVYTRUCK = "Heavy Truck";
		public static final String HEAVYTRUCKTRAILER = "Heavy Truck With Trailer";
		public static final String CARGOSHIP = "Cargo Ship";
		public static final String TRAIN = "Train";
		public static final String FLIGHT = "Flight";
		public static final String OTHER = "Other";
		
	}

	private final String eventType;

	private ModeOfFreightType(String eventType) {
		this.eventType = eventType;
	}

	@Override
	public String toString() {
		return this.eventType;
	}
}
