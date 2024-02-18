package com.climate.decode.eventservice.enums;

public enum EventType {

	AFTERNOONEVENT(Names.AFTERNOONEVENT), MORNINGEVENT(Names.MORNINGEVENT),
	EVENINGEVENT(Names.EVENINGEVENT);

	public static class Names {
		public static final String AFTERNOONEVENT = "Afternoon Event";
		public static final String MORNINGEVENT = "Morning Event";
		public static final String EVENINGEVENT = "Evening Event";
	}

	private final String eventType;

	private EventType(String eventType) {
		this.eventType = eventType;
	}

	@Override
	public String toString() {
		return this.eventType;
	}
}
