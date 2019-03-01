package com.leetcode.problempackage;

import java.util.Arrays;

public class LargestNumber {

	public static void main(String[] args) {
		
		LargestNumber ln  = new LargestNumber();
		int [] nums = {121,12};
		System.out.println(ln.largestNumber(nums));
		
	}
	
	 public String largestNumber(int[] nums) {
	        Arrays.sort(nums);
	        int j = 0;
	        while( j<nums.length && nums[j]/10 < 1) j++;
	        j--;
	        int i = nums.length-1;
	        int end = j;
	        StringBuffer sb = new StringBuffer();
	        while(i>end && j > -1){
	        	int in = Character.getNumericValue(Integer.toString(nums[i]).charAt(0)) ;
	        	int jn = Character.getNumericValue(Integer.toString(nums[j]).charAt(0)) ;
	            if(in>jn){
	                sb.append(nums[i]);
	                i--;
	            }else if(in<jn){
	                sb.append(nums[j]);
	                j--;
	            }else{
	                if(nums[i]%10 > nums[j]%10){
	                    sb.append(nums[i]);
	                    i--;
	                }else{
	                    sb.append(nums[j]);
	                    j--;
	                }
	            }
	        } 
	        while(j>0) {
	            sb.append(nums[j]);
	            j--;
	        }
	        while(i>end) {
	             sb.append(nums[i]);
	             i--;
	        }
	        return sb.toString();
	    }

}
