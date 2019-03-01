package com.leetcode.problempackage;

public class MinimumSumPath {

	public static void main(String[] args) {
		int [] [] grid = {{1,2,3},{2,3,4},{4,5,6}};
		
		MinimumSumPath msp = new MinimumSumPath();
		System.out.println(msp.minPathSum(grid));

	}
	
	public int minPathSum(int[][] grid) {
        int s = grid[0][0];
        int i=0,j=0;
        for(i=1;i<grid[0].length;i++) {
         s+=grid[0][i];
         grid[0][i] = s;
        }
        
        s = grid[0][0];
        for(i=1;i<grid.length;i++) {
         s+=grid[i][0];
         grid[i][0] = s;
        }
        for(i=1;i<grid.length;i++){
            for(j=1; j < grid[i].length;j++){
                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

}
