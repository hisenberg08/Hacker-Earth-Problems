package com.leetcode.problempackage;

public class CherryPickup {

	static int [][] arr;
	static int count=0;
	public static void main(String[] args) {
		int[][] grid = new int[][]{
			  { 0, 1, -1},
			  { 1, -1,1},
			  { 1, 1, 1},
		};
		
		//System.out.println(cherryPickup(grid));
		System.out.println(cherryPickupDP1(grid));
		System.out.println("hello");
	}

	public static int cherryPickup(int[][] grid) {
		arr = grid;
		return cherryPickupRec(0,0);
    }
	
	public static int cherryPickupRec(int i ,int j){
		
		if(i>=arr.length-1 || j>=arr[0].length-1)
			return 0;
		
		if(arr[i+1][j] == -1 && arr[i][j+1]==-1)
			return count; 
		
		count = Math.max(arr[i+1][j]+cherryPickupRec(i+1, j), arr[i][j+1]+cherryPickupRec(i, j+1));
		return count;
	}
	
	public static int cherryPickupDP(int [][] grid){
		
		int length = grid.length;
		int width = grid[0].length;
		int [][] newGrid = new int[length+1][width+1];
		int max = 0;
		for(int i=0;i<length;i++){
			int count =0;
			int countStarted=-1;
			for(int j=0;j<width;j++){
				if(i+1<length-1 && grid[i+1][j]==-1 || j+1<width-1 && grid[i][j+1]==-1)
					max = -1;
				
				if(i+1 <length && j+1< width){
					if(grid[i+1][j]==-1 && grid[i][j+1]==-1){
						if(countStarted==-1){
							countStarted=i;
						}
						count++;
					}
				}
				
				max = Math.max(newGrid[i+1][j], newGrid[i][j+1])+grid[i][j];
				newGrid[i+1][j+1] =max;
			}
			if(count+countStarted-1==grid[i].length)
				return -2;
		}
		return newGrid[length][width];
	}

	public static int cherryPickupDP1(int [][] grid){
		
		int length = grid.length;
		int width = grid[0].length;
		int [][] newGrid = new int[length+1][width+1];
		int max = -1;
		for(int i=0;i<length;i++){
			for(int j=0;j<width;j++){
				if(grid[i][j]==-1)
					newGrid[i+1][j+1] = -1;
				else{
					int val = grid[i][j] + Math.max(newGrid[i][j+1], newGrid[i+1][j]);
					newGrid[i+1][j+1] = val;
					if(val>=max)
						max=val;
				}
			}
		}
		
		
		int i=length+1;
		int j=width+1;
		while(i>0 && j>0){
			if(newGrid[i][j-1] >= newGrid[i-1][j]){
				grid[i-1][j-2]=0;
				j-=1;
			}
			else{
				grid[i-2][j-1]=0;
				i-=1;
			}
		}
		
		if(newGrid[length][width]<max)
			return 0;
		return newGrid[length][width];
	}
}
