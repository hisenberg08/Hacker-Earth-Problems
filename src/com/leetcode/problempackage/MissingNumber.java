package com.leetcode.problempackage;

public class MissingNumber {

	public static void main(String[] args) {
			
		int [] nums = {0,2,3,4};
		MissingNumber mn = new MissingNumber();
		System.out.println(mn.missingNumber(nums));
	}
	
public int missingNumber(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int xor = 0;
        for(int i : nums){
            xor ^= i;
            if(i>max) max = i;
            if(i<min) min = i;
        }
        int allxor =0;
        int j = min;
        while(j< (max+1)) {
            allxor ^= j;
            j++;
        }
        
        return allxor^xor;
    }

}
