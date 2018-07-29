package com.barclays.card.interview.dbs.main;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.barclays.card.interview.service.dbs.model.Bag;

public class BagTest {
	
	Bag bag = new Bag("0001", "Concourse_A_Ticketing", "UA12");

	@Test
	public void testBag() {
		assertTrue(bag instanceof Bag);
	}
	
	@Test
	public void testGetBagNumber() {
		assertTrue(bag instanceof Bag);
		assertTrue(bag.getBagNumber() == "0001");
	}
	
	@Test
	public void testGetentryPoint() {
		
		assertTrue(bag instanceof Bag);
		assertTrue(bag.getEntryPoint() == "Concourse_A_Ticketing");
	}
	
	@Test
	public void testGetFlightId() {
		assertTrue(bag instanceof Bag);
		assertTrue(bag.getFlightId() == "UA12");
	}
}
