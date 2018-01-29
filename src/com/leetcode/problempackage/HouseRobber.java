package com.leetcode.problempackage;

/*House Robber 198
 * 
 * This problem could be solved using dynamic programming. The idea here is to find out max amount of
 * robery that could be done at any given instance of time. We keep calculating the same until the end
 * and the last value will give us the max amount that could be robbed.*/

public class HouseRobber {

	public static void main(String[] args) {
		int [] nums ={1,2,3,4,5,6,7,8,0,10,11,12,14};
		System.out.println(rob(nums));
		
	}
 static public int rob(int[] nums) {
	    
     int [] arr = new int[nums.length+2];
     arr[0]=0;
     arr[1]=0;
	 for(int i=0;i<nums.length;i++){
		 arr[i+2] = Math.max(nums[i]+arr[i], arr[i+1]);
      }
     return arr[arr.length-1];
    }
}
