package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumAreaRectangle {

	public int minAreaRect(int[][] points) {
        
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for(int [] arr: points){
            
            map.putIfAbsent(arr[0], new HashSet<Integer>());
            map.get(arr[0]).add(arr[1]);
        }
        
        int minArea = Integer.MAX_VALUE;
        for(int key: map.keySet()){
            
            List<Integer> sameCols = new ArrayList<Integer>(map.get(key));
            
            for(int i=0;i< sameCols.size();i++){
                
                for(int j=i+1; j<sameCols.size();j++){
                    
                    int val1 = sameCols.get(i);
                    int val2 = sameCols.get(j);
                    
                    
                    for(int key2: map.keySet()){
                        
                        if(key != key2 && 
                           map.get(key2).contains(val1) && map.get(key2).contains(val2)){
                            
                            int area = Math.abs(val1 - val2) * Math.abs(key2 - key);
                            
                            if(area < minArea ) minArea = area;
                        }
                        
                    }
                    
                }
                
            }
        }
        
        return minArea;
    }
	
	public static void main(String[] args) {
		
		MinimumAreaRectangle mar = new MinimumAreaRectangle();
		
		int [][] points = {{1,1},{1,3},{3,1},{3,3},{2,2}};
		
		System.out.println(mar.minAreaRect(points));

	}

}
