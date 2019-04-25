package com.leetcode.problempackage;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubarayLengthSumK {

public int maxSubArrayLen(int[] nums, int target) {
        
        if(nums.length == 0) return 0;
        if(nums.length == 1 && nums[0] == target) return 1;
        
        int [] arr = new int[nums.length + 1];
        
        arr[0] = 0;
        arr[1] = nums[0];
        for(int i =1; i< nums.length ; i++){
            
            arr[i+1] = arr[i] + nums[i];
            
        }
        
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        int maxLen = 0;
        for(int i= 0 ; i< arr.length; i++){
            
            
            if(map.containsKey(arr[i])){
                
                int val = map.get(arr[i]);
                maxLen = i - val > maxLen ? i - val : maxLen;
                
            }
            
            int val = arr[i] + target;
            if(!map.containsKey(val)){
                map.put(val, i);
            }
            
        }
        
        return maxLen;
    }
	
	public static void main(String[] args) {
		
		MaximumSubarayLengthSumK ms= new MaximumSubarayLengthSumK();
		
		int [] nums = {1,1,0};
		int target = 1;
		System.out.println(ms.maxSubArrayLen(nums, target));

	}

}
