package com.climate.decode.eventservice.enums;

public enum ModeOfFreightType {

	VAN(Names.VAN),LIGHTTRUCK(Names.LIGHTTRUCK), HEAVYTRUCK(Names.HEAVYTRUCK),
	HEAVYTRUCKTRAILER(Names.HEAVYTRUCKTRAILER),CARGOSHIP(Names.CARGOSHIP), TRAIN(Names.TRAIN), FLIGHT(Names.FLIGHT),
	OTHER(Names.OTHER);

	public static class Names {
		public static final String VAN = "Van";
		public static final String LIGHTTRUCK = "LIGHTTRUCK";
		public static final String HEAVYTRUCK = "HEAVYTRUCK";
		public static final String HEAVYTRUCKTRAILER = "HEAVYTRUCKTRAILER";
		public static final String CARGOSHIP = "CARGOSHIP";
		public static final String TRAIN = "TRAIN";
		public static final String FLIGHT = "FLIGHT";
		public static final String OTHER = "OTHER";
		
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
