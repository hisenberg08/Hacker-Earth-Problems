package com.leetcode.problempackage;

		/*Code to calculate the reverse of a integer number.
		This code is valid for -ve integers.
		Also it returns 0 if the reversed value of not in the range of int values of java*/

public class Reverseinteger {

	public static void main(String[] args) {
		System.out.println(reverse(-2147483648));
	}
	 public static int reverse(int x) {
	        
	        long reverse = 0;
	        while(x!=0){
	            reverse = reverse*10 + x%10;
	            x = x/10;
	        }
	        
	        if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE)
	        	return 0;
	         return (int)reverse;
	        
	    }
}
