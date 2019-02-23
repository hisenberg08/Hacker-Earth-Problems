package com.leetcode.problempackage;


//count number of one in binary representation of a number
public class CountOne {

	public static void main(String[] args) {
		CountOne co = new CountOne();
		System.out.println(co.findOne(7));

	}
	
	public int findOne (int n) {
		int sum =0;
		
		while(n>0) {
			sum += n &1;
			n = n >>1;
		}
		
		return sum;
	}

}
