package com.climate.decode.eventservice.enums;

public enum MarketExpenditureType {

	STATIONERY(Names.STATIONERY), TELECOMMUNICATION(Names.TELECOMMUNICATION),
	PRINTINGANDPUBLISHINGSERVICES(Names.PRINTINGANDPUBLISHINGSERVICES), WEBHOSTING(Names.WEBHOSTING);

	public static class Names {
		public static final String STATIONERY = "Stationery";
		public static final String TELECOMMUNICATION = "Telecommunication";
		public static final String PRINTINGANDPUBLISHINGSERVICES = "Printing And Publishing Services";
		public static final String WEBHOSTING = "Web Hosting";
		
	}

	private final String expenditureType;

	private MarketExpenditureType(String expenditureType) {
		this.expenditureType = expenditureType;
	}

	@Override
	public String toString() {
		return this.expenditureType;
	}
}
