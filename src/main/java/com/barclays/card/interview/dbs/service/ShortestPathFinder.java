package com.barclays.card.interview.dbs.service;

import java.util.List;

import com.barclays.card.interview.service.dbs.model.Edge;

public interface ShortestPathFinder {
	
	public String findShortestPath(String entryNode, String destNode, List<Edge> graphEdges);
}
