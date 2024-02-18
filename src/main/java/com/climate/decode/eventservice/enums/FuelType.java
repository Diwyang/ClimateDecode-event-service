package com.climate.decode.eventservice.enums;

public enum FuelType {

	PETROL(Names.PETROL),DIESEL(Names.DIESEL), BIOGAS(Names.BIOGAS),
	NATURALGAS(Names.NATURALGAS),ETHANOL(Names.ETHANOL), HYBRID(Names.HYBRID), OTHER(Names.OTHER);

	public static class Names {
		public static final String PETROL = "Petrol";
		public static final String DIESEL = "Diesel";
		public static final String BIOGAS = "Biogas";
		public static final String NATURALGAS = "Natural Gas";
		public static final String ETHANOL = "Ethanol";
		public static final String HYBRID = "Hybrid";
		public static final String OTHER = "Other";
		
	}

	private final String eventType;

	private FuelType(String eventType) {
		this.eventType = eventType;
	}

	@Override
	public String toString() {
		return this.eventType;
	}
}
