package com.barclays.card.interview.service.dbs.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShortestPath {
	
	Map<String,String> bagToShorestPathMap =  new HashMap<String, String>();

	public Map<String, String> getBagToShorestPathMap() {
		return bagToShorestPathMap;
	}


	@Override
	public String toString() {
		String shortestPath ="";
		ArrayList<String> keys = new ArrayList<String>(bagToShorestPathMap.keySet());
        for(int i=keys.size()-1; i>=0;i--){
            shortestPath += keys.get(i) +bagToShorestPathMap.get(keys.get(i))+"\n";
        }
		return shortestPath;

	}
}
