package com.leetcode.problempackage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItenerary {
	
	Map<String,PriorityQueue<String>> map;
    LinkedList<String> res;
    
    public List<String> findItinerary(String[][] tickets) {
        
        this.map = new HashMap<>();
        this.res = new LinkedList<>();
        for (String[] ticket : tickets) {
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).add(ticket[1]);
        }
        
        dfs("JFK");
        return res;
    }
    
    
    private void dfs(String airport){
        
        PriorityQueue<String> pq = map.get(airport);
        while( pq!= null && !pq.isEmpty())
            dfs(pq.poll());
        
        res.addFirst(airport);
    }
	
    public static void main(String[] args) {
		
    	
    	ReconstructItenerary ri  = new ReconstructItenerary();
    	String [][] tickets = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
    	ri.findItinerary(tickets);

	}
}
