package com.leetcode.problempackage;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {

    int cnt = 0;
    int maxXmove = 0;
    int maxYmove = 0;
    Set<String> set = new HashSet<>();
    public int numDistinctIslands(int[][] grid) {
        
        for(int i=0;i<grid.length;i++){
            
            for(int j = 0;j <grid[i].length ;j ++){
                
                if(grid[i][j] == 1) {
                	StringBuilder sb = new StringBuilder();
                	sb.append("o");
                	dfs(grid,i,j,sb);
                	if(!set.contains(sb.toString())) {
                		set.add(sb.toString());
                		cnt++;
                	}
                	
                }
            }
        }
        
        return cnt;
    }
    
    public void  dfs(int [][] grid, int x ,int y ,StringBuilder sb){
        
        
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0){
            
            return;
            
        }
        
        
        grid[x][y] = 0;
        
        dfs(grid, x + 1, y , sb.append("r"));
        dfs(grid ,x, y + 1 , sb.append("d"));
        dfs(grid ,x - 1, y , sb.append("l"));
        dfs(grid ,x , y - 1, sb.append("u"));
        
        sb.append("b");
        return;
    }
    
    
    public static void main(String [] args) {
    	
    	NumberOfDistinctIslands nodi = new NumberOfDistinctIslands();
    	int [][] grid = {{0,1,1},
    							{1,0,1},
    							{1,1,0}};
    	
    	System.out.println(nodi.numDistinctIslands(grid));
    	
    }
	
}
