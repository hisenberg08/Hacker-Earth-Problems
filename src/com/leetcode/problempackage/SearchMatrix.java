package com.leetcode.problempackage;

public class SearchMatrix {

	public static void main(String[] args) {
		
		
		SearchMatrix sm = new SearchMatrix();
		int [][] matrix = {{1,4,7,11},{2,   5,  8, 12},{3,   6,  9, 16},{10, 13, 14, 17},{18, 21, 23, 26}};
		int target = 26;
		System.out.println(sm.searchMatrix(matrix, target));

	}

	// this is a slow solution. Time complexity O(nlogn) worst case.
	 public boolean searchMatrix(int[][] matrix, int target) {
	        for(int i=0;i<matrix.length;i++){
	            int l=0, h=matrix[0].length-1;
	            int m = 0;
	            while(l<=h){
	                m= (h+l)/2;
	                if(target == matrix[i][m]) return true;
	                else if(target > matrix[i][m]) l+=1;
	                else h-=1;
	            }
	        }
	        return false;
	    }
}
