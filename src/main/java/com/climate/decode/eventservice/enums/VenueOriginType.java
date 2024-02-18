package com.climate.decode.eventservice.enums;

public enum VenueOriginType {

	RENEWABLE(Names.RENEWABLE), GRID(Names.GRID),
	UNKNOWN(Names.UNKNOWN), DISTRICTHEATING(Names.DISTRICTHEATING),
	HEATINGOIL(Names.HEATINGOIL),NATURALGAS(Names.NATURALGAS),
	OTHER(Names.OTHER),DISTRICTCOOLING(Names.DISTRICTCOOLING);

	public static class Names {
		public static final String RENEWABLE = "Renewable";
		public static final String GRID = "Grid";
		public static final String UNKNOWN = "Unknown";
		public static final String DISTRICTHEATING = "District Heating";
		public static final String HEATINGOIL = "Heating Oil";
		public static final String NATURALGAS = "Natural Gas";
		public static final String OTHER = "Other";
		public static final String DISTRICTCOOLING = "District Cooling";
		
	}

	private final String originType;

	private VenueOriginType(String originType) {
		this.originType = originType;
	}

	@Override
	public String toString() {
		return this.originType;
	}
}
