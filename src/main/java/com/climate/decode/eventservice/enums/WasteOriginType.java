package com.climate.decode.eventservice.enums;

public enum WasteOriginType {

	ESTCONSUMPTIONDURINGEVENT(Names.ESTCONSUMPTIONDURINGEVENT), CARBONFOOTPRINT(Names.CARBONFOOTPRINT);

	public static class Names {
		public static final String ESTCONSUMPTIONDURINGEVENT = "Est Consumption During Event";
		public static final String CARBONFOOTPRINT = "Carbon Footprint";
		
	}

	private final String originType;

	private WasteOriginType(String originType) {
		this.originType = originType;
	}

	@Override
	public String toString() {
		return this.originType;
	}
}
