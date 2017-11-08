package com.leetcode.problempackage;

		/*This code finds the longest palindrome in a given string. The idea here is to check for 
		 * substrings starting from each of the each of the character if they form 
		 * a palindrome.For each of the character in the substring we check for both even and odd 
		 * palindromic substring starting at that substring. 
		 * 
		 * In case of a number of palindromic substrings with same length, this code returns the substring whcih appeared first in the string.
		 * 
		 *  Complexity Analysis
		 *  --------------------------------------------
		 *  
		 *  This code checks for the palindromic substring for each of the n characters in the string. Hence worst case complexity of the algorithm could be said to O(n^2).
		 *  This is an in place algorithm, hence space complexity would be O(1). 
		 *  */

public class SubstringPalindrome {
	
	public static void main(String[] args) {
		System.out.println(findPalindrome("abcda"));
		
	}
	
	private static String findPalindrome(String str){
		
		int maxLength = 1, len = str.length();
		int start=0,high=0,low=0;
		
		if(str.length() == 0)
			return str;
		
		for(int i=1;i<len;i++){
			
			//finding odd palindrome which could start with 
			high = i+1;
			low =i-1;
			while(low>=0 && high<len && str.charAt(low)==str.charAt(high)){
				if((high-low+1) > maxLength){
					maxLength =high-low+1; 
					start  = low;
				}
				low--;
				high++;
			}
			
			
			//finding even palindrome
		
			high =i;
			low =i-1;
			while(low>=0 && high<len && str.charAt(low)==str.charAt(high)){
				if((high-low+1) > maxLength){
					start = low;
					maxLength =high-low+1; 
				}
				low--;
				high++;
			}
		}
		
		return str.substring(start, start+maxLength);
	}
}
