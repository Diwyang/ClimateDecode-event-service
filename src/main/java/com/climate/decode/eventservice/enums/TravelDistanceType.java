package com.climate.decode.eventservice.enums;

public enum TravelDistanceType {

	LOCAL(Names.LOCAL), SHORTDISTANCE(Names.SHORTDISTANCE),
	MIDDLEDISTANCE(Names.MIDDLEDISTANCE), LONGDISTANCE(Names.LONGDISTANCE);

	public static class Names {
		public static final String LOCAL = "Local";
		public static final String SHORTDISTANCE = "Short Distance";
		public static final String MIDDLEDISTANCE = "Middle Distance";
		public static final String LONGDISTANCE = "Long Distance";
		
	}

	private final String travelDistanceType;

	private TravelDistanceType(String travelDistanceType) {
		this.travelDistanceType = travelDistanceType;
	}

	@Override
	public String toString() {
		return this.travelDistanceType;
	}
}
