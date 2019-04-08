package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

	static List<List<Integer>> res = new ArrayList<>();
	public static void main(String[] args) {
		
		Permutations p = new Permutations();
		int [] nums = {1,2,3};
		p.permute(nums);
		
		for(List<Integer> a:  res) System.out.println(Arrays.toString(a.toArray()));
	}
    
    public List<List<Integer>> permute(int[] nums) {
        
        List<Integer> intList = new ArrayList<Integer>();
        for (int i : nums) intList.add(i);
        
        recur(new ArrayList<Integer>(), intList);
        
        return res;
    }
    
    public void recur(List<Integer> curr, List<Integer> rem){
        
        if(rem.size() == 0) res.add(new ArrayList<>(curr));
        
        for(int i=0;i<rem.size();i++){
            curr.add(rem.get(i));
            rem.remove(i);
            recur(curr,rem);
        }
    }

}
