package com.hackerrank.problempackageone;

import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;

/*Above problem was there in hacker rank performance optimization competition. It aimed at finding the count
 * of max element in an array.
 * Commented code is the on was given to be optimized.
 * 
 * The run time of uncommented code(my code) could be improved
 * of we could convert Integer array to int array*/

public class DragonProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			int n = 4;
			Integer [] ar = {3,2,1,3};
			System.out.println(castleTowers(n, ar));
	}

	  /*static int castleTowers(int n, Integer[] ar) {
	        Arrays.sort(ar, Collections.reverseOrder());
	        int maxi = ar[0];
	        int cnt = 1;
	        for (int i = 1; i < n; i++) {
	            if (maxi == ar[i]) {
	                cnt += 1;
	            } else {
	                break;
	            }
	        }
	        return cnt;
	    }*/
	static int castleTowers(int n, Integer[] ar) {
		
		//int[] arr = Arrays.stream(ar).mapToInt(Integer::intValue).toArray();
		int max =ar[0];
		int count =0;
		for(int i=0;i<n;i++){
			
			if(ar[i]>max){
				max =ar[i];
				count = 1;
			}
			else if(ar[i]==max){
				count++;
			}
		}
		
		return count;
	}
}
