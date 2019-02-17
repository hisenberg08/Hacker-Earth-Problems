package com.leetcode.problempackage;

public class SingleNonDuplicate {

	public static void main(String[] args) {

		int [] A = {3,3,7,7,10,11,11};
		SingleNonDuplicate snd= new SingleNonDuplicate();
		System.out.println(snd.singleNonDuplicate(A));
	}
	
	 public int singleNonDuplicate(int[] A) {
		  int h = A.length -1;
	        int l = 0;
	        int m = (h + l)/2;
	        while(l<h){
	            if((m-l)%2 == 0){
	                if(A[m]!=A[m+1] && A[m]!=A[m-1]) return A[m];
	                else if(A[m] == A[m-1]) h = m;
	                else l = m;
	            }else{
	                if(A[m]!=A[m+1] && A[m]!=A[m-1]) return A[m];
	                else if(A[m] == A[m-1]) l = m+1;
	                else h = m-1;
	            }
              m = (h + l)/2;
	        }
	        return A[m];
	    }
}
