package com.leetcode.problempackage;

public class PlayingWithArray {

	public static void main(String[] args) {

		int [] a = {1,1,2,3,4,4,5,5};
		System.out.println(removeDuplicates(a));
		System.out.println(removeElement(a,2));
		
	}
	
	/*This code removes the duplicates from a sorted array and returns the length of 
	 * array with no duplicates in O(n) time and O(1) space.
	 * 
	 *  The idea here is to replace the duplicate elements with the non duplicate ones.
	*/
	
	public static int removeDuplicates(int[] a) {
	        
	        int i =0;
	        for(int j=1;j<a.length;j++){
	            if(a[i]!=a[j]){
	                i++;
	                a[i] = a[j];
	            }
	        }
	        return i+1;
	    }
	 
	/*This code removes the elements with value val from a array in O(n) time and O(1 space)
	 * and returns the length of the sub-array with no elements with value val.*/
	
	 public static int removeElement(int[] a, int val) {
	        int i=0;
	        if(a.length == 1 && a[0] == val)
	            return 0;
	        if(a.length == 1 && a[0] != val)
	            return 1;
	        for(int j=0;j<a.length;j++){
	            if(a[j]!=val){
	                a[i] = a[j];
	                i++;
	            }
	        }
	        return i;
	    }
}
