package com.climate.decode.eventservice.enums;

public enum PeopleTravelType {

	ATTENDEES(Names.ATTENDEES), ORGANISERS(Names.ORGANISERS), SUBCONTRACTORS(Names.SUBCONTRACTORS);

	public static class Names {
		public static final String ATTENDEES = "Attendees";
		public static final String ORGANISERS = "Organisers";
		public static final String SUBCONTRACTORS = "sub Contractors";
	}

	private final String peopleTravelType;

	private PeopleTravelType(String eventType) {
		this.peopleTravelType = eventType;
	}

	@Override
	public String toString() {
		return this.peopleTravelType;
	}
}
