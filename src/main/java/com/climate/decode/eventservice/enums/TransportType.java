package com.climate.decode.eventservice.enums;

public enum TransportType {

	GROUND(Names.GROUND), AIR(Names.AIR);

	public static class Names {
		public static final String GROUND = "Ground";
		public static final String AIR = "Air";
		
	}

	private final String transportType;

	private TransportType(String transportType) {
		this.transportType = transportType;
	}

	@Override
	public String toString() {
		return this.transportType;
	}
}
