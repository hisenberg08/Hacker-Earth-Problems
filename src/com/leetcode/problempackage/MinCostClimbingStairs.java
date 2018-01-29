package com.leetcode.problempackage;

import java.util.Arrays;

public class MinCostClimbingStairs {
	static int [] memo;
	public static void main(String[] args) {

		int cost[] = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		memo = new int[cost.length+1];
		Arrays.fill(memo, -1);
		//System.out.println(minCostClimbingStairsGreedy(cost));
		//System.out.println(minCostClimbingStairsRec(-1, cost));
		System.out.println(minCostClimbingStairsRecWithDP(-1, cost));
		//System.out.println(minCostClimbingStairs(cost));
		System.out.println(Arrays.toString(memo));
	}

	//This is greedy approach to the problem but it yields incorrect results at times. It considers the best available option at that particular time
	
	 public static int minCostClimbingStairsGreedy(int[] cost) {
	        int totalCost =0;
	        int currStair =-1;
	        for(int i=0;i<cost.length-1;i++){
	        	System.out.println("current stair is: "+currStair);
	            if(currStair>=cost.length-1) return totalCost;
	            if(cost[i]<cost[i+1]){
	            	totalCost+=cost[i];
	            	currStair+=1;
	            }else{
	            	totalCost+=cost[i+1];
	            	currStair+=2;
	            }
	        }
			return totalCost;
	    }
	 
	 public static int minCostClimbingStairsRec(int index, int [] cost){
		 System.out.println("Checking for index:"+index);
		 if(index>cost.length-1)
			 return 0;
		 if(index==cost.length-1)
			 return cost[index];
		 
		 if(index==-1)
			 return Math.min(minCostClimbingStairsRec(index+1,cost),minCostClimbingStairsRec(index+2,cost));
		 
		 return cost[index] + Math.min(minCostClimbingStairsRec(index+1,cost),minCostClimbingStairsRec(index+2,cost));
	 }
	 
	 //This is the dynamic programming solution using memoization to the problem. Here I have used an additional array named memo.
	 public static int minCostClimbingStairsRecWithDP(int index, int [] cost){
		// System.out.println("Checking for index:"+index);
		 if(index==-1)
			 return Math.min(minCostClimbingStairsRecWithDP(index+1,cost),minCostClimbingStairsRecWithDP(index+2,cost));
		 if(memo[index]!=-1){
			 System.out.println("used");
			 return memo[index];
		 }
			 
		 
		 if(index>cost.length-1)
			 return 0;
		 if(index==cost.length-1)
			 return cost[index];
		 
		 int d = cost[index] + Math.min(minCostClimbingStairsRecWithDP(index+1,cost),minCostClimbingStairsRecWithDP(index+2,cost));
		 memo[index] = d;
		 return d;
	 }
	 
	 //This is not my code and is taken from leetcode solution.
	 /*Relating this solution to the above recursive solution
	  * 
	  * Since in recursive solution we need the next two elements to find the current index, we start here backwards.
	  * at each step we find the result by adding the cost at index and min cost of indexPlusOne and indexPlusTwo.
	  * 
	  *  In the end we return the min indexPlusOne and indexPlusTwo same as we did in recursive solution by checking at
	  *  index==-1, i.e. at the start we just need to check for the min of next two and not the current cost.
	  *  
	  * */
	 
	 public static int minCostClimbingStairs(int[] cost) {
	        int indexPlusOne = 0, indexPlusTwo = 0;
	        for (int i = cost.length - 1; i >= 0; --i) {
	            int currIndex = cost[i] + Math.min(indexPlusOne, indexPlusTwo);
	            indexPlusTwo = indexPlusOne;
	            indexPlusOne = currIndex;
	        }
	        return Math.min(indexPlusOne, indexPlusTwo);
	    }
}
