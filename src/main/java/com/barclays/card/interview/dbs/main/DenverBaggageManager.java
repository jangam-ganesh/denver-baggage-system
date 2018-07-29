package com.barclays.card.interview.dbs.main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.barclays.card.interview.dbs.Constants.Constants;
import com.barclays.card.interview.dbs.exceptions.IncorrectFileNameException;
import com.barclays.card.interview.dbs.exceptions.InvalidInputDataException;
import com.barclays.card.interview.dbs.service.ShortestPathFinder;
import com.barclays.card.interview.dbs.serviceImpl.ShortestPathFinderImpl;
import com.barclays.card.interview.service.dbs.model.Bag;
import com.barclays.card.interview.service.dbs.model.Edge;
import com.barclays.card.interview.service.dbs.model.ShortestPath;

public class DenverBaggageManager {
	
	/*
	 * This is the DenverBaggageManager which will return the Shortest Path to all
	 * baggage at airport.
	 */
	
	
	public static final String ERROR = "There is an issue with input file. Please check the file for data format and try again";
	
	/*
	 * This is the DenverBaggageManager which will return the Shortest Path to all
	 * baggage at airport.
	 * Input:  FileName 
	 * Output : Retuen the Shortest Path to all baggage at airport.
	 */
	
	public static ShortestPath getBaggageRoutes( final String fileName ) throws IOException{
		ShortestPath shortestPath = new ShortestPath();
		Scanner scanInput = null;
		ShortestPathFinder pathFinder = new ShortestPathFinderImpl();
			File inputFile = new File(fileName);
			if (inputFile.exists()) {
				try {
					scanInput = new Scanner(inputFile);
				} catch (FileNotFoundException ex) {
					throw new IncorrectFileNameException(
							"Please provide the correct input file name and try again !!!");
				}
			}

		if (null != scanInput) {
			List<Edge> edges = scanConveyorSystemGraph(scanInput);
			Map<String, String> departuresMap = scanDeparturesList(scanInput);
			for (Bag bag : scanBags(scanInput)) {
				String flightId = bag.getFlightId();
				String destinationGate = (flightId.equals(Constants.ARRIVAL) ? Constants.BAGGAGE_CLAIM
						: departuresMap.get(flightId));
				String sPath = pathFinder.findShortestPath(bag.getEntryPoint(), destinationGate, edges);
				shortestPath.getBagToShorestPathMap().put(bag.getBagNumber(), Constants.SPACE + sPath);
				//System.out.println(bag.getBagNumber() + Constants.SPACE + sPath);
			}
			scanInput.close();
		}
		
		return shortestPath;
	}

	/*
	 * This method scan the files and retuen the list  of Bags.
	 * Input:  Scanner of the input file. 
	 * Output : List<Bag> at the airport.
	 */

	private static List<Bag> scanBags(Scanner bagScanner) {
		String nextLine;
		List<Bag> bagList = new ArrayList<Bag>();
		do {
			nextLine = bagScanner.nextLine();
			String[] bagDetails = nextLine.trim().split("\\s+");
			if (bagDetails.length >= 3) {
				Bag bag = new Bag(bagDetails[0], bagDetails[1], bagDetails[2]);
				bagList.add(bag);
			} else {
				bagScanner.close();
				break;
			}
		} while (bagScanner.hasNextLine());
		return bagList;
	}

	/*
	 * This method scan the Departures list.
	 * Input:  Scanner of the input file. 
	 * Output : Map<String, String> which will have flight and the departure information. 
	 */
	private static Map<String, String> scanDeparturesList(Scanner departuresScanner) {
		String nextLine = departuresScanner.nextLine();
		Map<String, String> departuresMap = new HashMap<String, String>();
		while (!nextLine.startsWith(Constants.SECTION_HEAD)) {
			String[] departureDetails = nextLine.trim().split("\\s+");
			if (departureDetails.length >= 2) {
				departuresMap.put(departureDetails[0], departureDetails[1]);
			} else {
				throw new InvalidInputDataException(ERROR);
			}
			nextLine = departuresScanner.nextLine();
		}
		return departuresMap;
	}

	/*
	 * This method prepare the bidirectional graph based on the input data
	 * Input:  Scanner of the input file. 
	 * Output : List<Edge> for the graph to traverse to find the the shortest path. 
	 */
	private static List<Edge> scanConveyorSystemGraph(Scanner bidirectionalGrapgScanner) {

		String sectionLine = bidirectionalGrapgScanner.nextLine();

		if (!sectionLine.startsWith(Constants.SECTION_HEAD)) {
			throw new InvalidInputDataException(ERROR);
		}
		String nextLine = bidirectionalGrapgScanner.nextLine();
		List<Edge> edges = new ArrayList<Edge>();
		while (!nextLine.startsWith(Constants.SECTION_HEAD)) {
			String[] edgeDetails = nextLine.trim().split("\\s+");
			if (edgeDetails.length >= 3) {
				Edge edge = new Edge(edgeDetails[0], edgeDetails[1], Integer.valueOf(edgeDetails[2]));
				Edge reverseEdge = new Edge(edgeDetails[1], edgeDetails[0], Integer.valueOf(edgeDetails[2]));
				edges.add(edge);
				edges.add(reverseEdge);
			} else {
				throw new InvalidInputDataException(ERROR);
			}
			nextLine = bidirectionalGrapgScanner.nextLine();
		}
		return edges;
	}
}

