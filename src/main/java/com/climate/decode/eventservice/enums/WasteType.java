package com.climate.decode.eventservice.enums;

public enum WasteType {

	PETBOTTLE15(Names.PETBOTTLE15), GLASSBOTTLEWATER(Names.GLASSBOTTLEWATER),
	GLASSBOTTLEWINE(Names.GLASSBOTTLEWINE), PAPERANDCARDBOARD(Names.PAPERANDCARDBOARD),
	ORDINARYWASTE(Names.ORDINARYWASTE), ORGANICWASTE(Names.ORGANICWASTE),
	PLASTICS(Names.PLASTICS);

	public static class Names {
		public static final String PETBOTTLE15 = "Pet Bottle 1.5L";
		public static final String GLASSBOTTLEWATER = "Glass Bottle (Water)";
		public static final String GLASSBOTTLEWINE = "Glass Bottle (Wine)";
		public static final String PAPERANDCARDBOARD = "Paper And Cardboard";
		public static final String ORDINARYWASTE = "Ordinary Waste";
		public static final String ORGANICWASTE = "Organic Waste";
		public static final String PLASTICS = "Plastics";
	}

	private final String wasteType;

	private WasteType(String wasteType) {
		this.wasteType = wasteType;
	}

	@Override
	public String toString() {
		return this.wasteType;
	}
}
