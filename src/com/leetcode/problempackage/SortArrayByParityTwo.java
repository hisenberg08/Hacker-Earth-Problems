package com.leetcode.problempackage;

import java.util.Stack;

public class SortArrayByParityTwo {

	public static void main(String [] args) {
		SortArrayByParityTwo sa = new SortArrayByParityTwo();
		int [] A = {1,3,5,7,9,2,4,6,8,0};
		sa.sortArrayByParityII(A);
	}
	
	public int[] sortArrayByParityII(int[] A) {
        
		Stack<Integer> odd = new Stack<Integer>();
		Stack<Integer> even = new Stack<Integer>();
		int lastPlaceFilled = 0;
		
		for(int i=0;i<A.length;i++) {
			
			if(A[i]%2 ==0)  even.push(A[i]);
			else  odd.push(A[i]);
			
			if(lastPlaceFilled%2==0) {
				if(!even.isEmpty()) {
					A[lastPlaceFilled] = even.pop();	
					lastPlaceFilled++;
				}
			}else {
				if(!odd.isEmpty()) {
					A[lastPlaceFilled] = odd.pop();
					lastPlaceFilled++;
				}
			}
		}
		
		while(!even.empty() || !odd.empty() ) {
			if(lastPlaceFilled%2==0) {
				if(!even.isEmpty()) {
					A[lastPlaceFilled] = even.pop();	
					lastPlaceFilled++;
				}
			}else {
				if(!odd.isEmpty()) {
					A[lastPlaceFilled] = odd.pop();
					lastPlaceFilled++;
				}
			}
		}
		
		return A;
    }
}
