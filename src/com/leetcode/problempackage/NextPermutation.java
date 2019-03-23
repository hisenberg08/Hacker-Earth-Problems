package com.leetcode.problempackage;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		
		NextPermutation np = new NextPermutation();
		int [] nums = {7,9,1,2,8,6,3};
		nums = np.nextPermutation(nums);
		for(int n:nums) System.out.print(n + " ");
	}
	
	public int[] nextPermutation(int[] nums) {
	      
        boolean flag = true;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i] > nums[i-1]){
                flag = false;
                break;
            }
        }
        if(flag) Arrays.sort(nums);
        else{
            int swap = 0;
             for(int i=nums.length-1;i>0;i--){
                if(nums[i]>nums[i-1]){
                    swap = i-1;
                    break;
                }
            }
            int j =swap;
            while(j+1<nums.length && nums[j+1]>nums[swap]) j++;
            int temp = nums[swap];
            nums[swap] = nums[j];
            nums[j] = temp;
            
            swap++;
            int k = nums.length-1;
            while(swap < k){
                temp = nums[swap];
                nums[swap] = nums[k];
                nums[k] = temp;
                swap++;
                k--;
            }
        }
        return nums;
    }

}
