package com.barclays.card.interview.dbs.main;

import junit.framework.Test;
import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

public class DenverBaggageSystemTest extends TestCase {

	public void testDenverBaggageSystem() {

		ByteArrayOutputStream outputSteream = new ByteArrayOutputStream();
		
		System.setOut(new PrintStream(outputSteream));
		
		DenverBaggageSystem.main(new String[] {"src/test/Input.txt"});
		
		assertEquals("0001 Concourse_A_Ticketing A5 A1 : 11\n" + "0002 A5 A1 A2 A3 A4 : 9\n" + "0003 A2 A1 : 1\n"
				+ "0004 A8 A9 A10 A5 : 6\n" + "0005 A7 A8 A9 A10 A5 BaggageClaim : 12\n", outputSteream.toString());
	}
}
