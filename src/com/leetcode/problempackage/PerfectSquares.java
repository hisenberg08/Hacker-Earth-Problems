package com.leetcode.problempackage;

public class PerfectSquares {

	public static void main(String[] args) {
		PerfectSquares ps = new PerfectSquares();
		int n = 12;
		System.out.println(ps.numSquares(n));

	}
	
public int numSquares(int n) {
        
        int [] arr = new int[n+1];
        for(int i=0;i<arr.length;i++) arr[i] = i;
        
        for(int i=2;i< Math.sqrt(n); i++){
            for(int j=1;j<arr.length;j++){
                if(j-i*i>-1)
                    arr[j] = Math.min(arr[j],arr[j-i*i]+1);
            }
        }
        return arr[arr.length-1];
    }

}
