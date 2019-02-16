package com.leetcode.problempackage;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ArrayPartition {

	public static void main(String[] args) {
		ArrayPartition ap = new ArrayPartition();
		int [] nums = {1,2,3,2};
		System.out.println(ap.arrayPairSumTwo(nums));
		
	}

	public int arrayPairSum(int[] nums) {
   
		Arrays.sort(nums);
		int sum =0;
		for(int i=0;i<nums.length;i+=2) {
			sum+=nums[i];
		}
		
	return sum;
   }
	
	//less efficient
	public int arrayPairSumTwo(int[] nums) {
	
	PriorityQueue<Integer> pq = new PriorityQueue<>();
	for(int i=0;i<nums.length;i++)
		pq.add(nums[i]);
	
	int sum =0;
	for(int i=0;i<nums.length/2;i++) {
		sum+=pq.poll();
		pq.poll();
	}
	return sum;
   }
}
