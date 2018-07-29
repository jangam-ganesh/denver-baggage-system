package com.barclays.card.interview.service.dbs.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

import com.barclays.card.interview.dbs.exceptions.ConveyorSystemGraphMapException;

public class ConveyorSystemGraph {

	private final Map<String, Node> conveyorSystemMap;

	public ConveyorSystemGraph(List<Edge> edges) {

		conveyorSystemMap = new HashMap<String, Node>(edges.size());
		for (Edge e : edges) {
			if (!conveyorSystemMap.containsKey(e.getSource().getName())) {
				conveyorSystemMap.put(e.getSource().getName(), new Node(e.getSource().getName()));
			}
			if (!conveyorSystemMap.containsKey(e.getDestination().getName())) {
				conveyorSystemMap.put(e.getDestination().getName(), new Node(e.getDestination().getName()));
			}
		}
		for (Edge e : edges) {
			conveyorSystemMap.get(e.getSource().getName()).getAdjacentNodes()
					.put(conveyorSystemMap.get(e.getDestination().getName()), e.getTime());
		}
	}

	public void lookupShortestPath(String startName) {
		Node source, adjacentNode;
		if (!conveyorSystemMap.containsKey(startName)) {
			throw new ConveyorSystemGraphMapException(
					"This conveyorSystemMap does not contain the starting node with name :" + startName);
		}
		final Node sourceNode = conveyorSystemMap.get(startName);
		NavigableSet<Node> queue = new TreeSet<Node>();

		for (Node node : conveyorSystemMap.values()) {
			node.setPrevNode(node == sourceNode ? sourceNode : null);
			node.setTotalTime(node == sourceNode ? 0 : Integer.MAX_VALUE);
			queue.add(node);
		}

		while (!queue.isEmpty()) {

			source = queue.pollFirst();
			if (source.getTotalTime() == Integer.MAX_VALUE)
				break;

			for (Map.Entry<Node, Integer> entry : source.getAdjacentNodes().entrySet()) {
				adjacentNode = entry.getKey();
				final int alternateTime = source.getTotalTime() + entry.getValue();
				if (alternateTime < adjacentNode.getTotalTime()) {
					queue.remove(adjacentNode);
					adjacentNode.setTotalTime(alternateTime);
					adjacentNode.setPrevNode(source);
					queue.add(adjacentNode);
				}
			}
		}

	}

	public List<Node> getShortestPath(String endName) {
		if (!conveyorSystemMap.containsKey(endName)) {
			throw new ConveyorSystemGraphMapException("Graph doesn't contain end node : " + endName);
		}

		return conveyorSystemMap.get(endName).getShortestPathTo();
	}
}
