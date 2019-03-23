package com.leetcode.problempackage;

public class MaxconequtiveOneT {

	public static void main(String[] args) {
		
		MaxconequtiveOneT  mqo = new MaxconequtiveOneT();
		
		int [] nums = {1,0,1,1,0,1}; 
		System.out.println(mqo.findMaxConsecutiveOnes(nums));

	}
	
	 public int findMaxConsecutiveOnes(int[] nums) {
	        
	        int cnt =0, maxCnt =0;
	        boolean flipped = false;
	        for(int i=0;i<nums.length;i++){
	            
	            if(nums[i] == 1){
	                cnt++;
	            }else{
	                if(i+1<nums.length && nums[i+1] ==1 && !flipped){
	                    cnt++;
	                }else{
	                    if(cnt > maxCnt) maxCnt = cnt;
	                    cnt=0;
	                    flipped = false;
	                }
	                
	            }
	        }
	        if(cnt > maxCnt) maxCnt = cnt;
	        return maxCnt;
	    }

}
