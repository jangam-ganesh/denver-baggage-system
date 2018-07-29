package com.barclays.card.interview.dbs.main;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

import com.barclays.card.interview.dbs.exceptions.IncorrectFileNameException;
import com.barclays.card.interview.dbs.exceptions.MissingInputArgumentException;

import junit.framework.TestCase;

public class DenverBaggageSystemTest extends TestCase {

	@Test
	public void testMainSystem() {

		ByteArrayOutputStream outputSteream = new ByteArrayOutputStream();
		
		System.setOut(new PrintStream(outputSteream));
		
		DenverBaggageSystem.main(new String[] {"src/test/Input.txt"});
		
		assertEquals("0001 Concourse_A_Ticketing A5 A1 : 11\n" + "0003 A2 A1 : 1\n" +"0002 A5 A1 A2 A3 A4 : 9\n" + 
				 "0005 A7 A8 A9 A10 A5 BaggageClaim : 12\n"+ "0004 A8 A9 A10 A5 : 6\n\n", outputSteream.toString());
	}
	
	@Test(expected = IncorrectFileNameException.class) 
	public void testForInvalidInput() throws IOException {
		DenverBaggageManager.getBaggageRoutes("src/test/Input1.txt");
	}
	
	@Test(expected = MissingInputArgumentException.class) 
	public void testMissingInputFileName() {
		DenverBaggageSystem.main(new String[] {""});
		
	}
}
