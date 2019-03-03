package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
			
		SpiralMatrix sm = new SpiralMatrix();
		int [][] m = {{1,2,3,4}};
		List<Integer> lis = sm.spiralOrder(m);
		for(int i: lis) System.out.print(i + " ");
	}
	
public List<Integer> spiralOrder(int[][] m) {
        
        
        List<Integer> lis = new ArrayList<>();
        if(m.length == 0) return lis;
        
        int top = 0;
        int bottom = m.length-1;
        int left = 0;
        int right = m[0].length-1;
        //boolean flag = false;
        //if(m.length == 1 || m[0].length ==1) flag =true;
        
        while(top <=bottom && left <=right){

        	for(int i = left;i<=right;i++){
                lis.add(m[top][i]);
            }top++;
            
            for(int i = top;i<=bottom;i++){
                lis.add(m[i][right]);
            }right--;
            
            if(top<=bottom) {
            	 for(int i = right;i>=left;i--){
                     lis.add(m[bottom][i]);
                 }bottom--;
            }
            
            if(left<=right) {
            	 for(int i = bottom;i>=top;i--){
                     lis.add(m[i][left]);
                 }left++;
            }
        }

        return lis;
    }

}
