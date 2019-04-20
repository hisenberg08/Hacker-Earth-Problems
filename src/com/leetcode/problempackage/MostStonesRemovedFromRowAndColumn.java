package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import javafx.util.Pair;

// performance for this code could be improved significantly by using union find method
public class MostStonesRemovedFromRowAndColumn {

	Map<Integer, List<Integer>> rowMap;
    Map<Integer, List<Integer>> colMap;
        
    public int removeStones(int[][] stones) {
        
        this.rowMap = new HashMap<>();
        this.colMap = new HashMap<>();
        
        for(int [] point : stones){
            
            int x = point[0];
            int y = point[1];
            
            rowMap.putIfAbsent(x,new ArrayList<>());
            rowMap.get(x).add(y);
            
            colMap.putIfAbsent(y,new ArrayList<>());
            colMap.get(y).add(x);
        }
        
        Set<Pair<Integer,Integer>> visited = new HashSet<>();
        int ans = 0;
        for(int [] point : stones){
            
            int row = point[0];
            int col = point[1];
            
            if(!visited.contains(new Pair<Integer, Integer>(row,col))){
                
                visited.add(new Pair<Integer, Integer>(row,col));
                ans += dfs(row,col,visited);
                break;
            }
        }
        return ans;
        
    }
    
    public int dfs(int row, int col, Set<Pair<Integer,Integer>> seen){
        
        
        int total = 0;
        Stack<Pair<Integer,Integer>> st = new Stack<>();
        st.push(new Pair<Integer, Integer>(row,col));
        
        while(!st.isEmpty()){
            
            Pair<Integer,Integer> pair = st.pop();
            
            row = pair.getKey();
            col = pair.getValue();
            
            List<Integer> rowList = rowMap.get(pair.getKey());
            List<Integer> colList = colMap.get(pair.getValue());
            
             for(Integer in : rowList){
            
                if(!seen.contains(new Pair<Integer, Integer>(row,in))){
                    seen.add(new Pair<Integer, Integer>(row,in));
                    total+=1;
                    st.push(new Pair<Integer, Integer>(row,in));
                }
            }
            
            
            for(Integer in : colList){
            
                if(!seen.contains(new Pair<Integer, Integer>(in,col))){
                    seen.add(new Pair<Integer, Integer>(in,col));
                    total+=1;
                    st.push(new Pair<Integer, Integer>(in, col));
                }
            }
            
        }
        
        return total;
    }
    
    public static void main(String [] args) {
    	
    	MostStonesRemovedFromRowAndColumn ms = new MostStonesRemovedFromRowAndColumn();
    	
    	int [][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
    	
    	ms.removeStones(stones);
    	
    	
    }
	
	
}
