
/*Solution to Maximum Sub Array Problem. (Leet code :- Problem 53)
 * 
 * This code finds the contiguous subarray in the given array.
 *Here I have used Kadane's algorithm to solve the problem. A good explanation of the algorithm could be found here https://www.youtube.com/watch?v=ohHWQf1HDfU&t=702s
 *
 * This code has the time complexity of O(n)
 *
 * */
package com.leetcode.problempackage;

import java.util.Arrays;

public class MaximumSubarrayProblem {

	public static void main(String[] args) {
		
		//int [] arr = {-2,1,-3,4,-1,2,1,-5,4};
		int [] arr = {-2,1,2};
		
		
		int [] maxSumArr = new int[arr.length];
		maxSumArr[0] = arr[0];
		int startIndex=0,endIndex =0;
		int finalMax = arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i] > maxSumArr[i-1]+arr[i]){
				startIndex =i;
				maxSumArr[i] = arr[i];
			}else
				maxSumArr[i] = maxSumArr[i-1]+arr[i];
			
			if(finalMax < maxSumArr[i]){
				finalMax = maxSumArr[i];
				endIndex =i;
			}
		}
		int [] finalArr = Arrays.copyOfRange(arr, startIndex, endIndex+1);
		System.out.println(Arrays.toString(finalArr));
	}

}
