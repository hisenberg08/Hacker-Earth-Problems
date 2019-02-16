// Leetcode problem number 238

package com.leetcode.problempackage;

import java.util.Arrays;

public class ProductExceptSelf {

	public static void main(String[] args) {
		
		int [] arr = {1,2,0,4};
		System.out.println(Arrays.toString(productExceptSelf(arr)));
	}

	public static int[] productExceptSelf(int[] nums) {
	     
        int product = 1;
        int zeroCount =0;
        for(int i: nums){
            if(i!=0) {
             product*=i;   
            }else zeroCount++;
        }
        
        if(zeroCount>1)
            for(int i=0;i<nums.length;i++)
                nums[i] = 0;
        else if(zeroCount ==1){
            for(int i=0;i<nums.length;i++)
                if(nums[i]!=0) 
                    nums[i] = 0;
                else
                    nums[i] = product;
        }else{
            for(int i=0;i<nums.length;i++)
                 nums[i] = product/nums[i];
        }
        return nums;
    }
}
