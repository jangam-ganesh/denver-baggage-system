package com.barclays.card.interview.dbs.main;

import java.io.IOException;

import com.barclays.card.interview.dbs.exceptions.DenverBaggageSystemException;
import com.barclays.card.interview.dbs.exceptions.MissingInputArgumentException;
import com.barclays.card.interview.service.dbs.model.ShortestPath;

public class DenverBaggageSystem {

	/*
	 * This is the DenverBaggageSystem which will guide Denver baggage system to route the 
	 * baggage at airport.
	 * 
	 * Input : Is the file containing the Conveyor System , Departure and bags information. 
	 */
	
	public static void main(String[] args){
		
		if (args.length > 0) {
			String fileName = args[0];
			try {
				ShortestPath shortestPath = DenverBaggageManager.getBaggageRoutes(fileName);
				System.out.println(shortestPath.toString());
			} catch (IOException e) {
				throw new DenverBaggageSystemException("Contact Denver Baggage Claim System.!!!");
			}
		} else {
			throw new MissingInputArgumentException("Please provide the input file name and try again !!!");
		}
	}
	
}
	
	
