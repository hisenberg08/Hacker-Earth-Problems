package com.leetcode.problempackage;

import java.util.Stack;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		
		
		LargestRectangleInHistogram lr = new LargestRectangleInHistogram();
		int [] he  = {2,1,5,6,2,3};
		System.out.println(lr.largestRectangleArea(he));

	}
	
public int largestRectangleArea(int[] he) {
        
	
	Stack<Integer> st = new Stack<Integer>();
    st.push(-1);
    st.push(0);
    int curr = 1;
    int idx =0;
    int area = 0;
    int maxArea = 0;
    while(!st.isEmpty() && curr<he.length){
        if(he[curr] > he[st.peek()]){
            st.push(curr++);
        }else{
            while(st.size()>1 && he[st.peek()] > he[curr]){
                idx = st.pop();
                area = he[idx] * (curr -idx);
                if(area > maxArea) maxArea = area;
            }
            st.push(curr++);
        }
    }
    
    if(st.size() > 1 && curr == he.length){
        while(st.size() > 1){
            idx = st.pop();
            area = he[idx] * (idx - st.peek());
            if(area > maxArea) maxArea = area;
        }
    }
    return maxArea;
    }
}
