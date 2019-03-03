package com.leetcode.problempackage;

import java.util.HashSet;
import java.util.Set;

public class MinimumCostForTickets {

	Set<Integer> se = new HashSet<>();
    Integer [] memo = new Integer[366];
    int [] costG;
	
    
    //This solution is correct but it takes huge amount of time if longer inputs are provided.
	public static void main(String[] args) {
		
		int [] costs = {9,38,134};
		int [] days = {1,2,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,20,21,24,25,27,28,29,30,31,34,37,38,39,41,43,44,45,47,48,49,54,57,60,62,63,66,69,70,72,74,76,78,80,81,82,83,84,85,88,89,91,93,94,97,99};
		
		MinimumCostForTickets mcft = new MinimumCostForTickets();
		System.out.println(mcft.mincostTickets(days, costs));
	}
	
    public int mincostTickets(int[] days, int[] costs) {
        costG = costs;
        for(int day: days) se.add(day);
        
        return rec(1);
    }
    
    public int rec(int i){
        
        if(i>365) return 0;
        
        if(memo[i]!=null) return memo[i];
        int ans =0;
        if(se.contains(i)){
                ans = Math.min(costG[0]+rec(i+1) , 
                           Math.min (costG[1]+rec(i+7),costG[2]+rec(i+30)));     
        }else{
            ans = rec(i+1);
        }
        return ans;
    }
}
