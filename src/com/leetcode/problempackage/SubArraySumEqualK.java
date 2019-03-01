package com.leetcode.problempackage;

public class SubArraySumEqualK {

	public static void main(String[] args) {
		SubArraySumEqualK sub = new SubArraySumEqualK();
		int [] nums = {1,1,1,1,1};
		int k = 2;
		System.out.println(sub.subarraySum(nums, k));

	}
	
public int subarraySum(int[] nums, int k) {
        
        int count = 0;
        for(int i=1;i<nums.length;i++){
            nums[i] = nums[i] + nums[i-1];
        }
        
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j] -nums[i] == k){
                    count+=1;  
                } 
            }
            if(nums[i] == k) {
                count+=1;
            }
        }
        
        return count;
    }

}
