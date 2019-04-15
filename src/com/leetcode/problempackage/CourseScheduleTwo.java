package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CourseScheduleTwo {

	public static void main(String[] args) {
		
		CourseScheduleTwo cs = new CourseScheduleTwo();
		
		int numCourses = 7;
		int [][] prerequisites = {{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};
		int [] res = cs.findOrder(numCourses, prerequisites);
		
		System.out.println(Arrays.toString(res));

	}
	
	Map<Integer,List<Integer>> graph;
	int [] visited;
    int [] res;
    int idx;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
    	this.graph = new HashMap<Integer,List<Integer>>();
        this.visited = new int [numCourses];
        this.res = new int[numCourses];
        this.idx = 0;
        
        for(int i=0;i<prerequisites.length;i++){
            
            if(!graph.containsKey(prerequisites[i][0])){
                List<Integer> li = new ArrayList<>();
                li.add(prerequisites[i][1]);
                graph.put(prerequisites[i][0],li);
                
            }else{
                graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
        }
        for(int i=0;i<visited.length;i++){
            if(visited[i]!=2) {
                if (!dfs(i)) return new int [] {};
            }
        }
        return res;
    }
    
    public boolean dfs(int n){
        
Stack<Integer> st = new Stack<Integer>();
        
        st.push(n);
        while(!st.isEmpty()){
            visited[st.peek()] = 1;
           if(!graph.containsKey(st.peek())) {
        	   int pop =st.pop(); 
        	   visited[pop] = 2;
        	   res[idx] = pop;
        	   idx++;
        	   System.out.println(Arrays.toString(res));
        	   continue;
           }
        	
        	List<Integer> curr = graph.get(st.peek());
            boolean flag = true;
            for(int i: curr){
                if(visited[i] == 1) return false;
                else if(visited[i]!=2) {
                	st.push(i);
                	//visited[i] = 1;
                	flag = false;
                	break;
                }
            }
            
            if(flag){
            	int pop =st.pop(); 
         	   visited[pop] = 2;
         	   res[idx] = pop;
         	   idx++;
         	  System.out.println(Arrays.toString(res));
            }
        }
        return true;
    }

}
