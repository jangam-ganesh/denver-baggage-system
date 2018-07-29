package com.barclays.card.interview.dbs.main;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.barclays.card.interview.service.dbs.model.Edge;
import com.barclays.card.interview.service.dbs.model.Node;

public class EdgeTest {
	
	Node sourceNode = new Node("A5");
	Node destNode = new Node("A10");
	Edge edge = new Edge(sourceNode, destNode, 4);
	

	@Test
	public void testEdge() {
		assertTrue(edge instanceof Edge);
	}
	
	@Test
	public void testGetDestination() {
		assertTrue(edge instanceof Edge);
		assertTrue(edge.getDestination() == destNode );
	}
	
	@Test
	public void testGetSource() {
		assertTrue(edge instanceof Edge);
		assertTrue(edge.getSource() ==  sourceNode);
	}
	
	@Test
	public void testGetFlightId() {
		assertTrue(edge instanceof Edge);
		assertTrue(edge.getTime() == 4);
	}
}
