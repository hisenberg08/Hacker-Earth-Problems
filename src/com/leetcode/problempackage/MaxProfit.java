package com.leetcode.problempackage;

/*leetcode problem number 121*/
public class MaxProfit {

	public static void main(String[] args) {

		int [] a = {1,2,4};
		System.out.println(maxProfit(a));
		System.out.println(maxProfit2(a));
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

	 /*leetcode problem number 122*/
	 
	 public static int maxProfit2(int[] a) {
	        int min=100000000,maxProfit = 0,prev = -1;
	        for(int i=0;i<a.length;i++){
	            if(prev < a[i]){
	                int x = a[i] - min;
	                if(x >= 0) 
	                	maxProfit = maxProfit+x;
	            }
	            min = a[i];
	            prev = a[i];
	        }
	        return maxProfit;
	    }
}
