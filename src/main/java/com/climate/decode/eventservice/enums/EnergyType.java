package com.climate.decode.eventservice.enums;

public enum EnergyType {

	RENEWABLEENERGY(Names.RENEWABLEENERGY), ELECTRICITY(Names.ELECTRICITY),
	ENERGYFORHEATING(Names.ENERGYFORHEATING), ENERGYFORCOOLING(Names.ENERGYFORCOOLING),
	OTHERFUELCONSUMPTION(Names.OTHERFUELCONSUMPTION);

	public static class Names {
		public static final String RENEWABLEENERGY = "Reneable Energy";
		public static final String ELECTRICITY = "Electricity";
		public static final String ENERGYFORHEATING = "Energy For Heating";
		public static final String ENERGYFORCOOLING = "Energy For Cooling";
		public static final String OTHERFUELCONSUMPTION = "Other Fuel Consumption";
	}

	private final String energyType;

	private EnergyType(String energyType) {
		this.energyType = energyType;
	}

	@Override
	public String toString() {
		return this.energyType;
	}
}
