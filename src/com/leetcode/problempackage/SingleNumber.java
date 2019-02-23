package com.leetcode.problempackage;

public class SingleNumber {

	public static void main(String[] args) {

			SingleNumber sn = new SingleNumber();
			int [] nums = {-999,1,5,1,-999};
			System.out.println(sn.singleNumber(nums));;
	}
	
	public int singleNumber(int [] nums) {
		int res =0;
		for(int i: nums) {
			int t =res ^i; 
			res = t;
		}
		return res;
	}

}
