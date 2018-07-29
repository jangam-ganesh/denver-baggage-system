package com.barclays.card.interview.service.dbs.model;

public class Bag {

	/*
	 * This class is holds the below details <bag_number> <entry_point> <flight_id>
	 * Marked all fields final because we do not want anyone to change the bags
	 * details once it is in the system.
	 */

	private final String bagNumber;
	private final String entryPoint;
	private final String flightId;

	// This is bag constructor with bag number , entry point and flight id.
	public Bag(String bagNumber, String entryPoint, String flightId) {
		
		this.flightId = flightId;
		this.bagNumber = bagNumber;
		this.entryPoint = entryPoint;
	}

	public String getBagNumber() {
		return bagNumber;
	}

	public String getEntryPoint() {
		return entryPoint;
	}

	public String getFlightId() {
		return flightId;
	}
}