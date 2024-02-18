package com.climate.decode.eventservice.enums;

public enum AttendeeType {

	INPERSON(Names.INPERSON), VIRTUAL(Names.VIRTUAL);

	public static class Names {
		public static final String INPERSON = "In Person";
		public static final String VIRTUAL = "Virtual";
	}

	private final String eventType;

	private AttendeeType(String eventType) {
		this.eventType = eventType;
	}

	@Override
	public String toString() {
		return this.eventType;
	}
}
