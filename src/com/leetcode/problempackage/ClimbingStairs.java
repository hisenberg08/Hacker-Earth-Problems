package com.leetcode.problempackage;

/*This class has two solutions to climbing stairs problem, leetcode problem 70. climbStairsRecursive is the recursive solution and climbStairsDP is the dynamic programming solution 
 *to the problem. The DP solution is using bottom up approach and worst case running time of the code is O(n)*/

public class ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(climbStairsRecursive(1));
		System.out.println(climbStairsDP(1));

	}
	
	public static int climbStairsRecursive(int n){
		
		if(n==1)
			return 1;
		if(n==2)
			return 2;
					
		return climbStairsRecursive(n-1)+climbStairsRecursive(n-2);
	}
	
	public static int climbStairsDP(int n){
		int [] arr = new int[n+1];
		
		if(n<=0) return 0;
		if(n==1) return 1;
		if(n==2) return 2;

		arr[0]=0;
		arr[1]=1;
		arr[2]=2;
		
		for(int i=3;i<=n;i++){
			arr[i] = arr[i-1]+arr[i-2];
		}
		return arr[n];
	}
}
