package com.climate.decode.eventservice.enums;

public enum DisposalTreatmentType {

	LANDFILL(Names.LANDFILL), INCINERATION(Names.INCINERATION), RECYCLING(Names.RECYCLING),
	COMPOSTING(Names.COMPOSTING);

	public static class Names {
		public static final String LANDFILL = "Landfill";
		public static final String INCINERATION = "Incineration";
		public static final String RECYCLING = "Recycling";
		public static final String COMPOSTING = "Composting";
	}

	private final String treatmentType;

	private DisposalTreatmentType(String treatmentType) {
		this.treatmentType = treatmentType;
	}

	@Override
	public String toString() {
		return this.treatmentType;
	}
}
