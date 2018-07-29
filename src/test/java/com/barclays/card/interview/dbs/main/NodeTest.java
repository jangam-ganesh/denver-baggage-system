package com.barclays.card.interview.dbs.main;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.barclays.card.interview.service.dbs.model.Node;

public class NodeTest {

	Node sourceNode = new Node("A5");
	Node destNode = new Node("A10");
	

	@Test
	public void testNode() {
		assertTrue(sourceNode instanceof Node);
		assertTrue(destNode instanceof Node);
	}
	
	@Test
	public void testGetName() {
		assertTrue(sourceNode instanceof Node);
		assertTrue(sourceNode.getName() == "A5");
	}
	
	@Test
	public void testGetTotalTime() {
		assertTrue(sourceNode instanceof Node);
		assertTrue(sourceNode.getTotalTime() == Integer.MAX_VALUE);
	}
	
	@Test
	public void testGetAdjacentNodes() {
		assertTrue(sourceNode instanceof Node);
		assertTrue(sourceNode.getAdjacentNodes().size()==0);
	}
	
	@Test
	public void testGetPrevNode() {
		assertTrue(sourceNode instanceof Node);
		assertTrue(sourceNode.getPrevNode()==null);
	}
}
