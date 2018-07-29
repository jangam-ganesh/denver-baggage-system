package com.barclays.card.interview.dbs.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.barclays.card.interview.dbs.Constants.Constants;
import com.barclays.card.interview.dbs.service.ShortestPathFinder;
import com.barclays.card.interview.service.dbs.model.ConveyorSystemGraph;
import com.barclays.card.interview.service.dbs.model.Edge;
import com.barclays.card.interview.service.dbs.model.Node;

public class ShortestPathFinderImpl implements ShortestPathFinder {

	Map<String, ConveyorSystemGraph> traversedMap = new ConcurrentHashMap<String, ConveyorSystemGraph>();

	@Override
	public String findShortestPath(String entryGate, String destinationGate, List<Edge> edges) {
		
		ConveyorSystemGraph conveyorSystemGraph = null;
		
		if (traversedMap.containsKey(entryGate)) {
			conveyorSystemGraph = traversedMap.get(entryGate);
		} else {
			conveyorSystemGraph = new ConveyorSystemGraph(edges);
			traversedMap.put(entryGate, conveyorSystemGraph);
			conveyorSystemGraph.lookupShortestPath(entryGate);
			
		}

		List<Node> shortestPathList = conveyorSystemGraph.getShortestPath(destinationGate);
		StringBuffer ShortestPathLine = new StringBuffer();
		for (Node node : shortestPathList) {
			ShortestPathLine.append(node.getName()).append(Constants.SPACE);
		}
		ShortestPathLine.append(": ").append(shortestPathList.get(shortestPathList.size() - 1).getTotalTime());
		return ShortestPathLine.toString();
	}
}
