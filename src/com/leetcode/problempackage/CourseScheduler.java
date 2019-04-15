package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CourseScheduler {

	public static void main(String[] args) {
		
		
		CourseScheduler cs = new CourseScheduler();
		int numCourses = 1;
		int [] [] prerequisites = {{1,0,},{0,1}};
		System.out.println(cs.canFinish(numCourses, prerequisites));

	}
	
	Map<Integer,List<Integer>> graph;
    int [] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        this.graph = new HashMap<Integer,List<Integer>>();
        this.visited = new int [numCourses+1];
        
        for(int i=0;i<prerequisites.length;i++){
            
            if(!graph.containsKey(prerequisites[i][0])){
                List<Integer> li = new ArrayList<>();
                li.add(prerequisites[i][1]);
                graph.put(prerequisites[i][0],li);
                
            }else{
                graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
        }
        
        boolean result = false;
        for(int i=0;i<visited.length;i++){
            if(visited[i]!=2) {
                result = dfs(i);
                if(!result) return false;
            }
        }
        return true;
    }
    
    public boolean dfs(int n){
        
        Stack<Integer> st = new Stack<Integer>();
        
        st.push(n);
        while(!st.isEmpty()){
            
           if(!graph.containsKey(st.peek())) {
        	   visited[st.pop()] = 2;
        	   continue;
           }
        	
        	List<Integer> curr = graph.get(st.peek());
            boolean flag = true;
            for(int i: curr){
                if(visited[i] == 1) return false;
                else if(visited[i]!=2) {
                	st.push(i);
                	visited[i] = 1;
                	flag = false;
                }
            }
            
            if(flag){
                visited[st.pop()] = 2;
            }
        }
        return true;
    }
}
