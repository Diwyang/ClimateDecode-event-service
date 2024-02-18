package com.climate.decode.eventservice.enums;

public enum ModeOfTransportType {

	CARTAXI(Names.CARTAXI),ENVIRONMENTCARTAXI(Names.ENVIRONMENTCARTAXI), CHARTEREDBUS(Names.CHARTEREDBUS),
	BUS(Names.BUS),SUBWAY(Names.SUBWAY), TRAM(Names.TRAM), TRAIN(Names.TRAIN), FLIGHT(Names.FLIGHT),
	OTHER(Names.OTHER);

	public static class Names {
		public static final String CARTAXI = "Car/Taxi";
		public static final String ENVIRONMENTCARTAXI = "Environmetal Car/Taxi";
		public static final String CHARTEREDBUS = "Chartered Bus";
		public static final String BUS = "Bus";
		public static final String SUBWAY = "Subway";
		public static final String TRAM = "Tram";
		public static final String TRAIN = "Train";
		public static final String FLIGHT = "Flight";
		public static final String OTHER = "Other";
		
	}

	private final String eventType;

	private ModeOfTransportType(String eventType) {
		this.eventType = eventType;
	}

	@Override
	public String toString() {
		return this.eventType;
	}
}
