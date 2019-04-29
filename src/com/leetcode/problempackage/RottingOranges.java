package com.leetcode.problempackage;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

	
public int orangesRotting(int[][] grid) {
        
        
        Queue<Integer> xq = new LinkedList<Integer>();
        Queue<Integer> yq = new LinkedList<Integer>();
        
        for(int i=0;i < grid.length;i++){
            for(int j=0;j < grid[i].length;j++){
                
                if(grid[i][j] == 2){
                    xq.add(i);
                    yq.add(j);
                }
            }
        }
        
        
        int elemInThisLayer = xq.size();
        int elemInNextLayer = 0;
        
        int depth = 0;
        while(!xq.isEmpty()){
            
            int x = xq.poll();
            int y = yq.poll();
            
            
            if(x+1 < grid.length && grid[x + 1][y] == 1){
                xq.add(x+1);
                yq.add(y);
                elemInNextLayer++;
                grid[x+1][y] = 2;
            }
            
            if(y+1 < grid[0].length && grid[x][y+1] == 1){
                xq.add(x);
                yq.add(y+1);
                elemInNextLayer++;
                grid[x][y+1] = 2;
            }
            
            if(x - 1 >=0 && grid[x - 1][y] == 1){
                xq.add(x - 1);
                yq.add(y);
                elemInNextLayer++;
                grid[x-1][y] = 2;
            }
            
            if(y - 1 >= 0 && grid[x][y-1] == 1){
                xq.add(x);
                yq.add(y-1);
                elemInNextLayer++;
                grid[x][y-1] = 2;
            }
            
            elemInThisLayer--;
            if(elemInThisLayer == 0) {
                
                if(elemInNextLayer == 0) continue;
                
                elemInThisLayer = elemInNextLayer;
                elemInNextLayer = 0;
                depth+=1;
            }
        }
        
        for(int i=0;i < grid.length;i++){
            for(int j=0;j < grid[i].length;j++){
                
                if(grid[i][j] == 1){
                    
                    return -1;
                }
            }
        }
        
        depth = depth == -1 ? 0 : depth;
        
        return depth;
    }

	public static void main(String[] args) {
		
		
		RottingOranges ro = new RottingOranges();
		int [][] grid = {{2,2},{1,1},{0,0},{2,0}};
		
		ro.orangesRotting(grid);

	}
	

}
