package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	int [] candidates;
    static List<List<Integer>> res;
	public static void main(String[] args) {
		
		CombinationSum cs = new CombinationSum();
		
		int [] candidates = {2,3,6,7};
		int target = 7;
		cs.combinationSum(candidates, target);
		
		for(List<Integer> lis : res) System.out.println(Arrays.toString(lis.toArray()));
	}
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        res = new ArrayList<>();
        this.candidates = candidates;
        
        recur(new ArrayList<Integer>(), target,0);
        return res;
    }
    
    
    //To generate all the combination and not the unique ones, start the loop from 0 everytime.
    
    public void recur(List<Integer> curr, int target, int start){
        
        if(target < 0) return;
        
        if(target == 0) res.add(new ArrayList<>(curr));
        
        
            for(int i=start;i<candidates.length;i++){
                curr.add(candidates[i]);
                recur(curr, target - candidates[i],i);
                curr.remove(curr.size()-1);
            }
    }

}
