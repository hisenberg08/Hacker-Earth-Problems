package com.leetcode.problempackage;

/*leetcode problem number 121*/
public class MaxProfit {

	public static void main(String[] args) {

		int [] a = {7,1,5,3,6,4};
		System.out.println(maxProfit(a));
	}

	 public static int maxProfit(int[] a) {
	        
	        int maxProfit=0,min = 100000000;
	        for(int i=0;i<a.length;i++){
	        	int x = a[i] - min;
	            if(x>maxProfit) maxProfit = x;
	            if(a[i]<min) min = a[i];
	        }
	        
	        return maxProfit;
	    }
}
