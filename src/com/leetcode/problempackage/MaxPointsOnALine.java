package com.leetcode.problempackage;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

public int maxPoints(int[][] points) {
        
        
        int globalMax = 1;
        for(int i = 0;i < points.length ; i++){
            
            Map<Double, Integer> map = new HashMap<Double,Integer>();
            int max = 1;
            for(int k = 0;k < points.length ;k++){
                
                if(i != k){
                    
                    int [] cord1 = points[i];
                    int [] cord2 = points[k];
                    
                    double slope = 0.0;
                    if(cord2[0] - cord1[0] == 0){
                        slope = Double.MAX_VALUE;
                    }else{
                        slope = calculateSlope(cord1[0],cord1[1],cord2[0],cord2[1]);
                    }
                    
                    if(!map.containsKey(slope)){
                        
                        map.put(slope,1);
                        
                    }else{
                        int cnt = map.get(slope);
                        if(++cnt > max) max = cnt;
                        map.put(slope, cnt);
                    }
                    
                }
                
                if(max > globalMax) globalMax = max;
            }
            
        }
        
        return globalMax+1;
        
    }
    
    private double calculateSlope(int x1, int y1, int x2, int y2){
        
        return (double)(y2 - y1) / (x2 - x1);
    }
	
	public static void main(String[] args) {
		
		MaxPointsOnALine mp  = new MaxPointsOnALine();
		
		int [][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
		System.out.println(mp.maxPoints(points));

	}

}
