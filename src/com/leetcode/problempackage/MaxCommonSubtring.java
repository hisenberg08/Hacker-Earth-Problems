package com.leetcode.problempackage;

		/*This code finds the longest substring that is common for the all the Strings in the input array.
		 * This is a brute force logic and takes O(n*m) time where n is the size of String array and m is the max size of string.
		 * 
		 *  This problem could be solved using divide and conquer approach in order to reduce the time complexity*/

public class MaxCommonSubtring {

	public static void main(String[] args) {

		String [] arr = {"aca","cba"};
		String max ="";
		if(arr.length >=2){
			max = maxSubStr(arr[0], arr[1]);
			for(int i= 2;i<arr.length ; i++){
				max = maxSubStr(max, arr[i]);
			}
			System.out.println(max);
		}else if(arr.length == 1)
			System.out.println(arr[0]);
		else
			System.out.println("");
		
		
	}

	public static String maxSubStr(String s1, String s2){
		

		int i =0, l1 = s1.length(), l2 = s2.length(), minLength=0;
		String nowStr = "", maxStr="";
		if(l1 > l2) minLength = l2;
		else minLength =l1;
		
		while(i<minLength){
		if(s1.charAt(i) == s2.charAt(i)){
			nowStr = nowStr+ s1.charAt(i);
		}else{
			if(nowStr.length() > maxStr.length())
				{
					maxStr = nowStr;
					nowStr = "";
				}
			}
		i++;
		}
		if(nowStr.length() > maxStr.length()) return nowStr;
		else return maxStr;
	}
}
