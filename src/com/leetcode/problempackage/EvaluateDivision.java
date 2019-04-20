package com.leetcode.problempackage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

	public static void main(String[] args) {
		
		EvaluateDivision  ed = new EvaluateDivision();
		
		String [][] equations = { {"a","b"},{"b","c"} };
		double [] values  = {2.0,3.0};
		String [][] queries = { {"a","c"},{"b","c"},{"a","e"},{"a","a"},{"x","x"} };
		
		ed.calcEquation(equations, values, queries);

	}
	
	Map<String,Map<String,Double>> map;
    double [] res;
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        this.map = new HashMap<>();
        for(int i=0;i<equations.length;i++){
            
            String a = equations[i][0];
            String b = equations[i][1];
            
            map.putIfAbsent(a, new HashMap<>());
            map.get(a).put(b, values[i]);
            
            map.putIfAbsent(b, new HashMap<>());
            map.get(b).put(a, 1/values[i]);
            
        }
        
        this.res = new double[queries.length];
        
        for(int i=0;i<queries.length;i++){
            
            String a = queries[i][0];
            String b = queries[i][1];
            
            Set<String> seen = new HashSet<String>();
            
            
            dfs(a,b,1,i,seen);
        }
        
        return res;
    }
    
    
    public void dfs(String a , String b, double curr, int i, Set<String> seen){
        
        if(a.equals(b)){
            res[i] = curr;
            return;
        }
        
        seen.add(a);
        
        Map<String,Double> li = map.get(a);
        
        for(String key : li.keySet()){
            
        	if(!seen.contains(key)) {
        		dfs(key, b, (double)(li.get(key)*curr),i,seen);
        	}
            
            
        }
        
        return;
    }

}
