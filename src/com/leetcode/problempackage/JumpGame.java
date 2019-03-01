package com.leetcode.problempackage;

public class JumpGame {

	public static void main(String[] args) {
		
		JumpGame jg = new JumpGame();
		int [] nums = {2,3,1,1,4};
		System.out.println(jg.canJump(nums));

	}
	
	public boolean canJump(int[] nums) {
        boolean [] arr = new boolean[nums.length];
        if(nums.length == 1) return true;
        if(nums[0] > 0) arr[0] = true;
        
        for(int i=0;i<nums.length;i++){
            int j = 1;
            if(arr[i]){
                while(i+j<nums.length && j<=nums[i]){
                //System.out.println(i + " " + j);
                arr[i+j] =true;
                j++;
            }
            }
        }
        if(arr[arr.length-1]) return true;
        else return false;
    }

}
