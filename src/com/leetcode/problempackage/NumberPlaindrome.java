package com.leetcode.problempackage;

		/*This code returns true or false if a number is palindrome or not.
		The idea here is to reverse a number and check if number and its 
		reverse are same or not. If yes then number is palindrome else not*/

public class NumberPlaindrome {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isPalindrome(12122));
	}
	  
	public static boolean isPalindrome(int x) {
	       long numIp = x, revIp = 0;
	        if(x<0)
	            return false;
	        while(x!= 0){
	            revIp = revIp * 10 + x%10;
	            x=x/10;
	        }
	        if(revIp == numIp)
	            return true;
	        return false;
	    }

}
