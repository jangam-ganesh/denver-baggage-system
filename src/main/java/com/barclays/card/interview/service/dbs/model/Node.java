package com.barclays.card.interview.service.dbs.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node implements Comparable<Node> {

	/*
	 * This class represents the node in the graph
	 * it will have 
	 * 1. Node Name
	 * 2. Previous node in the graph
	 * 3. Adjacent Nodes to the current nodes
	 * 4. Total time to the node based on the shortest travers time.
	 */
	
	private final String name;
	private Node prevNode = null;
	private final Map<Node, Integer> adjacentNodes = new HashMap<Node, Integer>();
	private int totalTime = Integer.MAX_VALUE;

	public Node(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public Node getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(Node prevNode) {
		this.prevNode = prevNode;
	}

	public Map<Node, Integer> getAdjacentNodes() {
		return adjacentNodes;
	}

	public int compareTo(Node other) {
		if (totalTime == other.totalTime)
			return name.compareTo(other.name);

		return Integer.compare(totalTime, other.totalTime);
	}

	public List<Node> getShortestPathTo() {
		List<Node> nodePathList = new ArrayList<Node>();
		nodePathList.add(this);
		Node node = this.getPrevNode();
		while (node != null && !nodePathList.contains(node)) {
			nodePathList.add(node);
			node = node.getPrevNode();
		}
		Collections.reverse(nodePathList);
		return nodePathList;
	}

	@Override
	public String toString() {
		return this.name + ":" + this.totalTime;
	}
}
