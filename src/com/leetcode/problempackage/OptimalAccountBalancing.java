package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalAccountBalancing {

	public static void main(String[] args) {
		
		OptimalAccountBalancing oab = new OptimalAccountBalancing();
		
		int [][] transactions = {{0,1,10},{2,0,5}};
		//{{2,0,5},{3,4,4}}
		//{{1,5,8},{8,9,8},{2,3,9},{4,3,1}};
		//{{0,1,10},{2,0,5}}
		System.out.println(oab.minTransfers(transactions));

	}
	
public int minTransfers(int[][] transactions) {
        
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int [] arr : transactions){
            
            map.put(arr[0],map.getOrDefault(arr[0],0)+arr[2]);
            map.put(arr[1],map.getOrDefault(arr[1],0)-arr[2]);
            
        }
        
        List<Integer> greaterThanZero = new ArrayList<Integer>();
        List<Integer> lessThanZero = new ArrayList<Integer>();
        
        int val = 0;
        for(Integer in : map.keySet()){
            val = map.get(in);
            if(val > 0) {
                
                greaterThanZero.add(val);
                
            }else if(val < 0 ) {
                
                lessThanZero.add(val);
                
            }
        }
        
        int cnt = 0;
        while(lessThanZero.size() !=0 && greaterThanZero.size()!=0){
            
        	int ltz = lessThanZero.get(0);
        	int gtz = greaterThanZero.get(0);
        			
        	
        	if(Math.abs(ltz) > gtz) {
        		lessThanZero.set(0, ltz  + gtz);
        	}else if(Math.abs(ltz) < gtz) {
        		greaterThanZero.set(0,gtz+ltz);
        	}else{
        		
        		lessThanZero.remove(0);
        		greaterThanZero.remove(0);
        	}
           cnt+=1;
        }
        return cnt;
    }

}
