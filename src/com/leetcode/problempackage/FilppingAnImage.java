package com.leetcode.problempackage;

import java.util.Arrays;

public class FilppingAnImage {

	public static void main(String[] args) {
		FilppingAnImage fp = new FilppingAnImage();
		
		int [][] A = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
		int [] [] B = fp.flipAndInvertImage(A);
		System.out.println("testing B");
		System.out.println(Arrays.toString(B));
	}

	
	public int[][] flipAndInvertImage(int[][] A) {
    
		int rows = A.length;
		int cols = A[0].length;
		int [][] B = new int[rows][cols];
		
		for(int i=0;i<rows;i++) {
			int k =0;
			for(int j=cols-1;j>=0;j--) {
				B[i][k] = reverseBit(A[i][j]);
				k++;
			}
		}
		return B;
    }
	
	public int reverseBit(int i) {
		if(i==1) return 0;
		else return 1;
	}
	
}
