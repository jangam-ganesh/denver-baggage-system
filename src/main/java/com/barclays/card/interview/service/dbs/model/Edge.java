package com.barclays.card.interview.service.dbs.model;

public class Edge {
	
	/*
	 * This class represents the edge to the graph
	 * it will have source to destination mapping based on the time to reach. 
	 */

	private final Node source;
	private final Node destination;
	private final int time;

	public Edge(Node source, Node destination, int time) {
		this.source = source;
		this.destination = destination;
		this.time = time;
	}

	public Edge(String sourceName, String destinationName, Integer time) {
		this.source = new Node(sourceName);
		this.destination = new Node(destinationName);
		this.time = time;
	}

	public Node getSource() {
		return source;
	}

	public Node getDestination() {
		return destination;
	}

	public int getTime() {
		return time;
	}
}
